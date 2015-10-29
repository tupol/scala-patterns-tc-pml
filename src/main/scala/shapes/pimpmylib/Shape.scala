package shapes.pimpmylib

trait Shape {
  def area: Double
}

case class Circle(val r: Double) extends Shape {
  def area = r * r * Math.PI
}

case class Square(val a: Double) extends Shape {
  def area = a * a
}
