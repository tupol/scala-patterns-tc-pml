package lables.pimpmylib


object LabelMaker {
  def createLabel(from : CanBeLabeled): String = from.label
}

trait CanBeLabeled {
  def label: String
}


