package shapes.typeclasses

import shapes.untouchable.{Square, Circle}


object Main extends App {

  def area[T](shape: T)(implicit calc: Calculator[T]): Double = {
    calc.area(shape)
  }

  def area[T](shapes: List[T])(implicit calc: Calculator[T]): List[Double] = {
    shapes.map(calc.area(_))
  }

  println(area(Circle(2)))
  println(area(Square(2)))

  val shapes = List(Circle(2), Square(2))
//  val areas = area(shapes)
//  println(areas)

  val r = (1 to 1000000000).view.filter(_ % 2 == 0).take(10).toList
  println(r)
  println("###############")


}
