package shapes.overloading


import Math._

import shapes.untouchable._

object Calculator {

  def area(shape: Circle): Double = shape.r * shape.r * PI

  def area(shape: Square): Double = shape.a * shape.a

  // Without this
  def area(shape: Shape): Double = shape match {
    case c : Circle => area(c)
    case s : Square => area(s)
  }

  def area(shapes : List[Shape]): List[Double] =
    shapes.map(area(_))


}



