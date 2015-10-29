import shapes.pimpmylib.{Square, Circle, Shape}

import shapes.untouchable.{Circle => UCircle, Square => USquare}

package object pimpmylib {

  implicit def decorateCircle(shape: UCircle): Shape =
    Circle(shape.r)

  implicit def decorateSquare(shape: USquare): Shape =
    Square(shape.a)

}
