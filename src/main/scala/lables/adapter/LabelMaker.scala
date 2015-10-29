package lables.adapter

import lables.model._

// Adapter interface
trait LabelMaker[T] {
  def createLabel(from : T): String
}

// Address adapter
object AddressLabelMaker extends LabelMaker[Address] {
  override def createLabel(from: Address): String =
    from.plain
}

// Product adapter
object ProductLabelMaker extends LabelMaker[Product] {
  override def createLabel(from: Product): String =
    from.name
}
