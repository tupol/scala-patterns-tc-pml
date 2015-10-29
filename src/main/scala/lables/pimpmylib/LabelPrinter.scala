package lables.pimpmylib

import lables.model._

object LabelPrinter {

  // Function using view bound syntactical sugar
  def printLabelSmall[T <% CanBeLabeled](from : T): Unit = {
    val toPrint = LabelMaker.createLabel(from)
    println(s"Small Label: $toPrint")
  }

  // Function using curried implicit modifier for the LabelMaker
  def printLabelLarge[T](from : T)(implicit convert: T => CanBeLabeled): Unit = {
    val toPrint = LabelMaker.createLabel(from)
    println(s"Large Label: $toPrint")
  }

}


object Main extends App {

  implicit def addressToLabel(from: Address) : CanBeLabeled = new CanBeLabeled {
    override def label: String = s"[local] $from.plain"
  }

  implicit def productToLabel(from: Product) : CanBeLabeled = new CanBeLabeled {
    override def label: String = s"[local] $from.name"
  }

  val printer = LabelPrinter

  val address = Address("My Address on Earth is...")
  printer.printLabelSmall(address)
  printer.printLabelLarge(address)

  val product = Product("Headphones")
  printer.printLabelSmall(product)
  printer.printLabelLarge(product)

}
