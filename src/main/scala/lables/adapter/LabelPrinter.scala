package lables.adapter

import lables.model.Address

// Client
case class LabelPrinter[T](labelMaker: LabelMaker[T]) {

  def printLabelSmall(from : T): Unit = {
    val toPrint = labelMaker.createLabel(from)
    println(s"Small Label: $toPrint")
  }

  def printLabelLarge(from : T): Unit = {
    val toPrint = labelMaker.createLabel(from)
    println(s"Large Label: $toPrint")
  }

}


object Main extends App {

  val printer = LabelPrinter(AddressLabelMaker)

  val address = Address("My Address on Earth is...")
  printer.printLabelSmall(address)
  printer.printLabelLarge(address)

}
