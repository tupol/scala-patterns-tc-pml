package decorator

import untouchable._


object Main extends App {
  val shapes = List(CircleWithDecoration(Circle(2)), SquareWithDecoration(Square(2)))
  val areas = shapes.map(_.area)
  println(areas)
}
