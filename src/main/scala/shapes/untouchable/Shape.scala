package shapes.untouchable

sealed trait Shape

final case class Square(a: Double) extends Shape

final case class Circle(r: Double) extends Shape

