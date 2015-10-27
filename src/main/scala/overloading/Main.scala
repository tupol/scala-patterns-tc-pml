package overloading

import untouchable._


object Main extends App {

  import Calculator._
  val shapes = List(Circle(2), Square(2))
  val areas = area(shapes)
  println(areas)
}
