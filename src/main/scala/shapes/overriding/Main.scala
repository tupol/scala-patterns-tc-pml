package shapes.overriding

import shapes.untouchable.{Square, Circle}

object Main extends App {

  val shapes = List(Circle(2), Square(2))
  val calculators = List[Calculator[_]](CircleCalculator, SquareCalculator)

//  val areas = calculators.zip(shapes).map {(c, s) => c.area(s)}
//  println(areas)
}
