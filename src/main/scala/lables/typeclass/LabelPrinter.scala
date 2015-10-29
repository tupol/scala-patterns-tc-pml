package lables.typeclass

import lables.model.{Address, Product}

class LabelPrinter {

  // Function using context bound syntactical sugar
  def printLabelSmall[T: LabelMaker](from : T): Unit = {
    val toPrint = implicitly[LabelMaker[T]].createLabel(from)
    println(s"Small Label: $toPrint")
  }

  // Function using curried implicit modifier for the LabelMaker
  def printLabelLarge[T](from: T)(implicit lm: LabelMaker[T]): Unit = {
    val toPrint = lm.createLabel(from)
    println(s"Large Label: $toPrint")
  }


}


object Main extends App {

//  implicit object AddressLabelMaker extends LabelMaker[Address] {
//    def createLabel(from: Address): String = s"[local] $from.plain"
//  }
//  implicit object ProductLabelMaker extends LabelMaker[Product] {
//    def createLabel(from: Product): String = s"[local] $from.name"
//  }

  val printer = new LabelPrinter

  val address = Address("My Address on Earth is...")
  printer.printLabelSmall(address)
  printer.printLabelLarge(address)

  val product = Product("headset")
  printer.printLabelSmall(product)
  printer.printLabelLarge(product)
}