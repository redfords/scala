object functions {

  // defining a function
  def multiplier(x: Int, y: Int): Int = { x * y }
  multiplier(6, 7) // returns 42

  // procedures
  // implicit return type
  def log1(d: Double) = println(f"Got value $d%.2f")

  // explicit return type
  def log2(d: Double): Unit = println(f"Got value $d%.2f")

  // functions with empty parentheses
  def hi(): String = "hi"

  // expression blocks
  def formatEuro(amt: Double) = f"€$amt%.2f"
  formatEuro(3.4645) // returns String = €3.46
  formatEuro { val rate = 1.32; 0.235 + 0.7123 + rate * 5.32 } // returns String = €7.97

  // recursive functions
  def power(x: Int, n: Int): Long = {
    if (n >= 1) x * power(x, n-1)
    else 1
  }

  // tail recursion optimization
  @annotation.tailrec
  def power(x: Int, n: Int, t: Int = 1): Int = {
    if (n < 1) t
    else power(x, n-1, x*t)
  }

  // nested functions
  def max(a: Int, b: Int, c: Int) = {
    def max(x: Int, y: Int) = if (x > y) x else y
    max(a, max(b, c))
  }

  // calling functions with named parameters
  def greet(prefix: String, name: String) = s"$prefix $name"
  val greeting1 = greet("Ms", "Brown") // returns String = Ms Brown
  val greeting2 = greet(name = "Brown", prefix = "Mr") // returns String = Mr Brown

  // defualt values
  def greeting(name: String, prefix: String = "") = s"$prefix$name"
  val greeting3 = greeting("Ola") // returns String = Ola

  // vaarg parameters
  def sum(items: Int*): Int = {
    var total = 0
    for (i <- items) total += i
    total
  }

  // parameter groups
  def max(x: Int)(y: Int) = if (x > y) x else y
  val larger = max(20)(39) // returns Int = 39

  // type parameters
  def identity[A](a: A): A = a
  val s: String = identity[String]("Hello") // returns s: String = Hello
  val d: Double = identity[Double](2.717) // returns d: Double = 2.717

  // methods and operators


  // writing readable functions


//  Write a function that computes the area of a circle given its radius.

//  Provide an alternate form of the function in exercise 1 that takes the radius as a
//  String . What happens if your function is invoked with an empty String ?

//  Write a recursive function that prints the values from 5 to 50 by fives, without using
//  for or while loops. Can you make it tail-recursive?

//  Write a function that takes a milliseconds value and returns a string describing the
//  value in days, hours, minutes, and seconds. What’s the optimal type for the input
//  value?

//  Write a function that calculates the first value raised to the exponent of the second
//  value. Try writing this first using math.pow , then with your own calculation. Did
//  you implement it with variables? Is there a solution available that only uses im‐
//  mutable data? Did you choose a numeric type that is large enough for your uses?

//  Write a function that calculates the difference between a pair of 2D points (x and
//  y) and returns the result as a point. Hint: this would be a good use for tuples (see
//  “Tuples” on page 25).

//  Write a function that takes a 2-sized tuple and returns it with the Int value (if
//  included) in the first position. Hint: this would be a good use for type parameters
//  and the isInstanceOf type operation.

//  Write a function that takes a 3-sized tuple and returns a 6-sized tuple, with each
//  original parameter followed by its String representation. For example, invoking
//  the function with (true, 22.25, "yes") should return (true, "true", 22.5,
//  "22.5", "yes", "yes") . Can you ensure that tuples of all possible types are com‐
//  patible with your function? When you invoke this function, can you do so with
//  explicit types not only in the function result but in the value that you use to store
//  the result?


}
