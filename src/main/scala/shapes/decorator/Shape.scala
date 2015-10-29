package shapes.decorator

import shapes.untouchable.{Circle => UCircle, Shape => UShape, Square => USquare}

// THE FOLLOWING CODE CAN NOT WORK, AS THE UNTOUCHEABLES ARE SEALED AND FINAL
//abstract class Shape(shape : UShape) extends UShape {
//  def area: Double
//}
//
//case class Circle(shape : UCircle) extends Shape(shape) {
//  def area = shape.r * shape.r * Math.PI
//}
//
//case class Square(shape : USquare) extends Shape(shape) {
//  def area = shape.a * shape.a
//}