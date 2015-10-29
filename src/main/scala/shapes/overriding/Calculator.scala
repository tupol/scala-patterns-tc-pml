package shapes.overriding

import Math.PI

import shapes.untouchable._


trait Calculator[T]  {
  def area(shape: T): Double
}

object CircleCalculator extends Calculator[Circle] {
  def area(shape: Circle): Double = shape.r * shape.r * PI
}

object SquareCalculator extends Calculator[Square] {
  def area(shape: Square): Double = shape.a * shape.a
}


