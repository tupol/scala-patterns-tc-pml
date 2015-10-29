# Type Classes Pattern

## Scope
This is a material for trying to explain the "type class" and the "pimp my library" patterns.

NOTE: The project contains code samples, some of them working, some of them not so much.

## Introduction
Among the first people trying to categorize polymorphism is C. Strachey, who, in 1967, identified two categories:
- *ad-hoc polymorphism*, referring to overriding and overloading
- *parametric polymorphism*, giving the example of how a map function works on a collection

The world of Haskell produced a new type of polymorphism, called *"type classes"*, merging the worlds of ad-hoc and parametric polymorphisms. This was basically made possible by the fact that there is a type inference mechanism available in Haskell, and, not surprisingly, in Scala as well.

## Problem

Given a library that can not be modified, or even better not even extendable, we need to create a new abstraction providing a functionality based on it (`LabelMaker.model`).

In our case we are given an `Address` and a `Product` class, both final (so extending is not an option) and they will serve as our *"adaptees"*.

We will develop an abstraction, let's call it `LabelMaker` that will produce label strings, and it will play the role of *"adapter interface"*.

In turn, the `LabelMaker` will be used by our `LabelPrinter` to print out nice labels, and will play the role of the *"client"*.

## Possible pattern solutions

### `labels.adapter`

The OOP approach is to build concrete adapters extending the newly created `LabelMaker` interface.

As a result, we will have to use a different adapter instance for each input type (e.g. one for `Address` and one for `Product`), unless we build a dispatcher on top, that can manage multiple data types.

### `labels.pimpmylib`
The "Odersky" approach is to use view bounds to do an implicit conversion.

According to Scala FAQ:
>A view bound was a mechanism introduced in Scala to enable the use of some type A as if it were some type B.
In other words, A should have an implicit conversion to B available, so that one can call B methods on an object of type A.

**Syntax:**
```scala
def f[A <% B](a: A) = a.bMethod
def f[A](a: A)(implicit ev: A => B) = a.bMethod
```

Since we want to apply an implicit conversion, we create an additional interface called `CanBeLabeled` that we will pass as an argument to the  `LabelMaker.createLabel()` method. Now we need to create implicit conversion methods from `Address` and `Product` to `CanBeLabeled`. Where should we put these methods is a different discussion, let's keep them in the `LabelPrinter` object.

Unlike the adapter pattern, our `LabelPrinter.printLabel....()` methods will work with any infput parameter type for which we defined a conversion.

### `labels.typeclasses`
The "Haskell" approach is to use the type classes pattern, which differs from the "pimp my lib" patter as it takes implicit parametric types instead of implicit conversion methods.

According to Scala FAQ:
>A context bound describes an implicit value, instead of view bound’s implicit conversion.
It is used to declare that for some type A, there is an implicit value of type B[A] available.

**Syntax:**
```scala
def f[A : B](a: A) = g(a)
def f[A](a: A)(implicit ev: B[A]) = g(a)
```

In this case ...


## Type class pattern

### Description
According to Scala FAQ:
>Basically, this pattern implements an alternative to inheritance by making functionality available through a sort of implicit adapter pattern.

### Components
1. A trait with parametric type. Let's call it *typed trait* (`Calculator[T]`)
2. A companion object for the *typed trait*, containing implicit implementations for each concrete type. (`CircleCalculator`, `SquareCalculator`)
3. A typed function that takes an implicit parameter of *typed trait* (`area[T](shape: T)(implicit calc: Calculator[T]): Double`)

### How it works (or how I think it works)
Calling `area(Circle(1))`
- will trigger the compiler to resolve the parametric type T as Circle,
- then look if there is any defined implicit object of type `Calculator[Circle]`
- which is found in the companion object associated to the `Calculator[T]` trait.
(This is mainly conjecture, but seems plausible)

Interesting to study the implicit search path.

According to the Scala Language Specification, the implicits are searched in the following order:
1. all identifiers x that can be accessed at the point of the method call without a prefix and that denote an implicit definition or an implicit parameter:
 - a local name, or
 - a member of an enclosing template, or
 - it may be have been made accessible without a prefix through an import clause
2. all `implicit` members of some object that belongs to the implicit scope of the implicit parameter's type, T.





## References

### Books
* "Fundamental Concepts in Programming Languages", Christopher Strachey, 1967
* "How to make ad-hoc polymorphism less ad hoc", Philip Wadler and Stephen Blott, 1988
* "Scala Language Specification", Martin Odersky & co, wip...
* "Atomic Scala", 2nd Edition, Bruce Eckel, Dianne Marsh
* "Scala in Depth", Joshua D. Suereth, 2012

### Web References
* "Scala FAQ: What are Scala context and view bounds?" (http://docs.scala-lang.org/tutorials/FAQ/context-and-view-bounds.html)
* "Pimp my Library", Martin Odersky, 2006 (http://www.artima.com/weblogs/viewpost.jsp?thread=179766)
* "Scala Implicits : Type Classes Here I Come" (http://debasishg.blogspot.nl/2010/06/scala-implicits-type-classes-here-i.html)
* "The Neophyte's Guide to Scala Part 12: Type Classes" ("http://danielwestheide.com/blog/2013/02/06/the-neophytes-guide-to-scala-part-12-type-classes.html")
