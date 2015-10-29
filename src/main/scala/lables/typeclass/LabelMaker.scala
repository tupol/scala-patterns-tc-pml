package lables.typeclass

import lables.model._

// Adapter interface / Type Class
trait LabelMaker[T] {
  def createLabel(from : T): String
 }

// Adapter object
object LabelMaker {

  // Address implicit adapter
  implicit object AddressLabelMaker extends LabelMaker[Address] {
    def createLabel(from: Address): String = s"[companion] $from.plain"
  }

  // Product implicit adapter
  implicit object ProductLabelMaker extends LabelMaker[Product] {
    def createLabel(from: Product): String = s"[companion] $from.name"
  }
}


