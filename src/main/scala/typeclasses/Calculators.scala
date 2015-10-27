package typeclasses

import untouchable._

trait Calculator[T] {
  def area(shape: T): Double
}

object Calculator {

  implicit object CircleCalculator extends Calculator[Circle] {
    def area(shape: Circle) = shape.r * shape.r * Math.PI
  }

  implicit object SquareCalculator extends Calculator[Square] {
    def area(shape: Square) = shape.a * shape.a
  }

}


