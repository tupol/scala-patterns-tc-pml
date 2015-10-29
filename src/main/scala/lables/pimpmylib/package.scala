package lables

import lables.model.{Product, Address}

package object pimpmylib {

  implicit def addressToLabel(from: Address) : CanBeLabeled = new CanBeLabeled {
    override def label: String = s"[package] $from.plain"
  }

  implicit def productToLabel(from: Product) : CanBeLabeled = new CanBeLabeled {
    override def label: String = s"[package] $from.name"
  }

}
