object firstClassFunctions {

  // function types and values
  // The type of a function is a simple grouping of its input types and return value type,
  // arranged with an arrow indicating the direction from input types to output type.

  def double(x: Int): Int = x * 2
  val myDouble: (Int) => Int = double

  // higher-order functions
  def safeStringOp(s: String, f: String => String) = {
    if (s != null) f(s) else s
    }

  def reverser(s: String) = s.reverse
  safeStringOp(null, reverser) // returns null
  safeStringOp("Ready", reverser) //returns ydaeR

  // function literals
  // a function literal is a working function that lacks a name
  val doubler = (x: Int) => x * 2
  val doubled = doubler(22) // returns 44

  // the function literal in this example is the syntax (x: Int) => x * 2
  // which defines a typed input argument ( x ) and the function body ( x * 2 )

  // let’s define a function value and assign it a new function literal:
  val greeter = (name: String) => s"Hello, $name"
  val hi = greeter("World") // returns Hello, World

  // placeholder syntax
  // placeholder syntax is a shortened form of function literals, replacing
  // named parameters with wildcard operators ( _ )
  val doubler2: Int => Int = _ * 2

  def safeStringOp2(s: String, f: String => String) = {
    if (s != null) f(s) else s
  }

  // partially applied functions and currying
  // reuse a function invocation and retain some parameters to avoid typing again
  def factorOf(a: Int, b: Int) = a % b == 0
  val f = factorOf (_, _)
  val x = f(7, 20) // returns false

  val multipleOf3 = factorOf(3, _: Int)
  val y = multipleOf3(78) // returns true

  // apply the parameters for one list while leaving another list unapplied
  // this is known as currying the function
  def factorOf(x: Int)(y: Int) = y % x == 0
  val isEven = factorOf(2) _
  val z = isEven(32) // returns true

  // by-name parameters
  def doubles(x: => Int) = {
      println("Now doubling " + x)
      x * 2
  }

  doubles(5) // returns Now doubling 5 Int = 10

  def f(i: Int) = { println(s"Hello from f($i)"); i }

  doubles( f(8) ) // returns Hello from f(8) Now doubling 8 Int = 16

  // invoking high-order functions with function literal blocks

  def safeStringOp3(s: String, f: String => String) = {
    if (s != null) f(s) else s
  }

  val uuid = java.util.UUID.randomUUID.toString // returns bfe1ddda-92f6-4c7a-8bfc-f946bdac7bc9

  val timedUUID = safeStringOp(uuid, { s =>
    val now = System.currentTimeMillis
    val timed = s.take(24) + now
    timed.toUpperCase
  })
    // returns BFE1DDDA-92F6-4C7A-8BFC-1394546043987

  // here is an alternate example, one that takes a single by-name parameter
  // we’ll make the function more generic with a type parameter used for the
  // by-name parameter return type and the main function’s return type

  def timer[A](f: => A): A = {
    def now = System.currentTimeMillis
    val start = now; val a = f; val end = now
    println(s"Executed in ${end - start} ms")
    a
  }

  val veryRandomAmount = timer {
    util.Random.setSeed(System.currentTimeMillis)
    for (i <- 1 to 100000) util.Random.nextDouble
    util.Random.nextDouble
  }
  // returns 0.5070558765221892

}
