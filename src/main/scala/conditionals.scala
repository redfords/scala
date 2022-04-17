object conditionals {

  // expressions
  val amount = { val x = 5 * 20; x + 10 }
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
  val word = message match {
    case "Ok" => 200
    case other => {
      println(s"Couldn't parse $other")
      -1
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
//  of 3, print “type,” and for multiples of 5, print “safe.” For multiples of both 3 and 5,
//  print “typesafe.”

//  Can you rewrite the answer to exercise 5 to fit on one line?


}
