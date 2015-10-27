package decoratorWithImplicits

import untouchable._


object Main extends App {


  def area[T <% ShapeWithDecoration[T]](shape: T) : Double =
    shape.area

  val shapes = List(Circle(2), Square(2))
  val areas = shapes.map(area(_))
  println(areas)
}
