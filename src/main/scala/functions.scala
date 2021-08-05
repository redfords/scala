object functions {

  def main(args: Array[String]): Unit = {
        val nombre = args(0)
        println("hola mi nombre es " + nombre)

          val estado = args(0).length()
          val r = scala.util.Random
          val d = r.nextInt(3)
          println(estado / d)

        def toInt(s: String): Int = {
          try {
            s.toInt
          } catch {
            case e: Exception => -1
          }
        }

        def resultado(n: Int): String = {
          if (n == 0) "par"
          else if (n > 0) "impar"
          else "no es un numero"
        }

        val n = toInt(args(0)) % 2
        println(resultado(n))
  }
}
