package shapes.decoratorWithImplicitConversions

import shapes.untouchable.{Circle => UCircle, Shape => UShape, Square => USquare}

/**
 * Decorator for the shapes.untouchable.Shape, adding the area() method
 */

// THE FOLLOWING CODE CAN NOT WORK, AS THE UNTOUCHEABLES ARE SEALED AND FINAL
//trait Shape extends UShape {
//  val shape: UShape
//  def area: Double
//}
//
//case class Circle(val shape : UCircle) extends Shape {
//  def area = shape.r * shape.r * Math.PI
//}
//
//case class Square(val shape : USquare) extends Shape {
//  def area = shape.a * shape.a
//}

