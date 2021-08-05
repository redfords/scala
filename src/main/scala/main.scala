import java.sql._

object main extends App {
  val JDBC_DRIVER = "org.postgresql.Driver"
  val DB_URL = "jdbc:postgresql://localhost:5433/test"
  val USER = "postgres"
  val PASS = "password"

  var conn: Connection = null
  var stmt: Statement = null

  try {
    Class.forName(JDBC_DRIVER)
    conn = DriverManager.getConnection(DB_URL, USER, PASS)
    stmt = conn.createStatement

    val insertSql = """
                      |insert into users (name,street,city,zip)
                      |values (?,?,?,?)
    """.stripMargin

    val preparedStmt: PreparedStatement = conn.prepareStatement(insertSql)

    preparedStmt.setString (1, "name")
    preparedStmt.setString (2, "street")
    preparedStmt.setString (3, "city")
    preparedStmt.setInt    (4, 1234)

    preparedStmt.execute

    preparedStmt.close()

    stmt.close
    conn.close
  } catch {
    case se: SQLException => se.printStackTrace
    case e: Exception => e.printStackTrace
  } finally {
    try {
      if (stmt != null) stmt.close
    } catch {
      case se2: SQLException =>
    }
    try {
      if (conn != null) conn.close
    } catch {
      case se: SQLException => se.printStackTrace
    }
  }

//  val sql = "SELECT * FROM USERS"
//
//  var conn: Connection = null
//  var stmt: Statement = null
//
//  try {
//    Class.forName(JDBC_DRIVER)
//    conn = DriverManager.getConnection(DB_URL, USER, PASS)
//    stmt = conn.createStatement
//    val rs: ResultSet = stmt.executeQuery(sql)
//    while (rs.next) {
//      val id = rs.getInt("id")
//      val name = rs.getString("name")
//      val street = rs.getString("street")
//      val city = rs.getString("city")
//      val zip = rs.getInt("zip")
//      println(s"$id, $name, $street, $city, $zip")
//    }

}