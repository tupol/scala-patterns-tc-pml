import shapes.untouchable.{Circle => UCircle, Square => USquare}

package object decoratorWithImplicitConversions {

// THE FOLLOWING CODE CAN NOT WORK, AS THE UNTOUCHEABLES ARE SEALED AND FINAL
//  implicit def decorateCircle(shape: UCircle): Shape =
//    Circle(shape)
//
//  implicit def decorateSquare(shape: USquare): Shape =
//    Square(shape)

}
