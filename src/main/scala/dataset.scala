object dataset {
  case class Person(name: String, age: Long)

  // Encoders are created for case classes
  val caseClassDS = Seq(Person("Andy", 32)).toDS()
  caseClassDS.show()
  // +----+---+
  // |name|age|
  // +----+---+
  // |Andy| 32|
  // +----+---+

  // Encoders for most common types are automatically provided by importing spark.implicits._
  val primitiveDS = Seq(1, 2, 3).toDS()
  primitiveDS.map(_ + 1).collect() // Returns: Array(2, 3, 4)

  // DataFrames can be converted to a Dataset by providing a class. Mapping will be done by name
  val path = "examples/src/main/resources/people.json"
  val peopleDS = spark.read.json(path).as[Person]
  peopleDS.show()
  // +----+-------+
  // | age|   name|
  // +----+-------+
  // |null|Michael|
  // |  30|   Andy|
  // |  19| Justin|
  // +----+-------+

  // Create an RDD of Person objects from a text file, convert it to a Dataframe
  val peopleDF = spark.sparkContext
    .textFile("examples/src/main/resources/people.txt")
    .map(_.split(","))
    .map(attributes => Person(attributes(0), attributes(1).trim.toInt))
    .toDF()
  // Register the DataFrame as a temporary view
  peopleDF.createOrReplaceTempView("people")

  // SQL statements can be run by using the sql methods provided by Spark
  val teenagersDF = spark.sql("SELECT name, age FROM people WHERE age BETWEEN 13 AND 19")

}
