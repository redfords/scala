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

  // partially applied functions and currying

  // by-name parameters

  // partial functions

  // invoking high-order functions with function literal blocks



}
