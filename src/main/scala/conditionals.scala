object conditionals {

  // expressions
  val amount = {
    val x = 5 * 20; x + 10
  }
  val x = 10
  val y = 20
  val max = if (x > y) x else y

  // match expression
  val max2 = x > y match {
    case true => x
    case false => y
  }

  val status = 500
  val message = status match {
    case 200 =>
      "ok"
    case 400 => {
      println("ERROR - we called the service incorrectly")
      "error"
    }
    case 500 => {
      println("ERROR - the service encountered an error")
      "error"
    }
  }

  // pattern alternative
  val day = "MON"

  val kind = day match {
    case "MON" | "TUE" | "WED" | "THU" | "FRI" =>
      "weekday"
    case "SAT" | "SUN" =>
      "weekend"
  }

  // wildcard pattern
  val word = "Ok"
  val result = word match {
    case "Ok" => 200
    case other => {
      println(s"Couldn't parse $other")
      -1
    }
  }

  // pattern guards
  val response: String = null
  val r = response match {
    case s if s != null => println(s"Received '$s'")
    case s => println("Error! Received a null response")
  }

  // pattern variables
  val a: Int = 12180
  val b: Any = a
  val c = b match {
    case x: String => s"'x'"
    case x: Double => f"$x%.2f"
    case x: Float => f"$x%.2f"
    case x: Long => s"${x}l"
    case x: Int => s"${x}i"
  }
  // returns 12180i

  // loops
  for (x <- 1 to 7) { println(s"Day $x:") }
  // returns Day 1:
  //Day 2:
  //Day 3:
  //Day 4:
  //Day 5:
  //Day 6:
  //Day 7:

  for (x <- 1 to 7) yield { s"Day $x:" }
  // returns Vector(Day 1:,
  //Day 2:, Day 3:, Day 4:, Day 5:, Day 6:, Day 7:)

  // iterator guard
  val threes = for (i <- 1 to 20 if i % 3 == 0) yield i
  // returns Vector(3, 6, 9, 12, 15, 18)

  val quote = "Faith,Hope,,Charity"
  for {
    t <- quote.split(",")
    if t != null
    if t.size > 0
  }
  { println(t) }
  // returns Faith
  // Hope
  // Charity

  // nested iterattors
  for { x <- 1 to 2
        y <- 1 to 3 }
  { print(s"($x,$y) ") }
  // returns (1,1) (1,2) (1,3) (2,1) (2,2) (2,3)

  // value binding
  val powersOf2 = for (i <- 0 to 8; pow = 1 << i) yield pow
  // returns Vector(1, 2, 4, 8, 16, 32, 64, 128, 256)

}



//  Given a string name , write a match expression that will return the same string if
//  nonempty, or else the string “n/a” if it is empty

//  Given a double amount , write an expression to return “greater” if it is more than
//  zero, “same” if it equals zero, and “less” if it is less than zero. Can you write this with
//  if..else blocks? How about with match expressions?

//  Write an expression to convert one of the input values cyan , magenta , yellow to
//  their six-char hexadecimal equivalents in string form. What can you do to handle
//  error conditions?

//  Print the numbers 1 to 100, with each line containing a group of five numbers. For
//  example:
//  1, 2, 3, 4, 5,
//  6, 7, 8, 9, 10
//  ....

//  Write an expression to print the numbers from 1 to 100, except that for multiples
//  of 3, print “type,” and for multiples of 5, print “safe.” For multiples of both 3 and 5
//  print “typesafe.”

//  Can you rewrite the answer to exercise 5 to fit on one line?

