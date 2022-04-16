object data {

  // defining a value
  val x: Int = 20
  val greeting: String = "Hello, World"
  val atSymbol: Char = '@'

  // defining a variable
  var y = 5
  y = y * 4
  var z1 = 20.5
  var z2 = z1.toInt

  // string interpolation java.util.Formatter
  val approx = 355/113f
  println("Pi, using 355/113, is about " + approx + "." )
  println(s"Pi, using 355/113, is about $approx." )

  val item = "apple"
  println(s"How do you like them ${item}s?")

  // regular expressions java.util.regex.Pattern
  val input = "Enjoying this apple 3.14159 times today"
  val pattern = """.* apple ([\d.]+) times .*""".r
  val pattern(amountText) = input
  val amount = amountText.toDouble // returns 3.14159

  // unit type a function that doesn't return data
  val nada = ()

  // common type operations
  //  5.asInstanceOf[Long]
  //  (7.0 / 5).getClass
  //  (5.0).isInstanceOf[Float]
  //  "A".hashCode Returns the hash code of the value, useful for hash-based collections
  //  20.toByte; 47.toFloat
  //  (3.0 / 4.0).toString

  // tuples
  val info = (5, "Korben", true)
  val name = info._2 // returns Korben

  // represent key-value pairs in tuples
  val red = "red" -> "0xff0000" // returns(red,0xff0000)
  val reversed = red._2 -> red._1 // returns (0xff0000,red)

//  Convert the temperature value of 22.5 Centigrade to Fahrenheit.
//  The conversion formula is cToF(x) = (x * 9/5) + 32

//  Modify the Centigrade-to-Fahrenheit formula to return an integer instead of a
//  floating-point number

//  Using the input value 2.7255 , generate the string “You owe $2.73.” Is this doable
//  with string interpolation?

//  Using the input string “Frank,123 Main,925-555-1943,95122” and regular expres‐
//  sion matching, retrieve the telephone number. Can you convert each part of the
//  telephone number to its own integer value? How would you store this in a tuple?


}
