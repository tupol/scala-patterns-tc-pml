package decoratorWithImplicits

import scala.language.{implicitConversions, higherKinds}

import untouchable.{Circle, Shape, Square}

abstract class ShapeWithDecoration(shape : Shape) extends Shape {
  def area: Double
}

case class CircleWithDecoration(shape : Circle) extends ShapeWithDecoration(shape) {
  def area = shape.r * shape.r * Math.PI
}

case class SquareWithDecoration(shape : Square) extends ShapeWithDecoration(shape) {
  def area = shape.a * shape.a
}

object ShapeWithDecoration {

  implicit def decorateCircle(shape: Circle): CircleWithDecoration =
    CircleWithDecoration(shape)

  implicit def decorateSquare(shape: Square): SquareWithDecoration =
    SquareWithDecoration(shape)

}