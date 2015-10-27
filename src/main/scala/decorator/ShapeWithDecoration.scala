package decorator

import untouchable.{Square, Circle, Shape}

abstract class ShapeWithDecoration(shape : Shape) extends Shape {
  def area: Double
}

case class CircleWithDecoration(shape : Circle) extends ShapeWithDecoration(shape) {
  def area = shape.r * shape.r * Math.PI
}

case class SquareWithDecoration(shape : Square) extends ShapeWithDecoration(shape) {
  def area = shape.a * shape.a
}