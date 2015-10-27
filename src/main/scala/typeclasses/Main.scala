package typeclasses



object Main extends App {

  implicit val cc = Calculator.CircleCalculator

  implicit val sc = Calculator.SquareCalculator


//  def area[T](shape: T)(implicit calc: Calculator[T]): Double = {
//    calc.area(shape)
//  }
//
//  val shapes = List(Circle(2), Square(2))
//  val areas = shapes.map(area(_))
//  println(areas)


}
