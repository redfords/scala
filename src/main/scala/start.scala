import org.apache.spark.sql.SparkSession

object start {
  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

  val flightData2015 = spark
    .read
    .option("inferSchema", "true")
    .option("header", "true")
    .csv("/data/flight-data/csv/2015-summary.csv")

  val sqlWay = spark.sql("""
  SELECT DEST_COUNTRY_NAME, count(1)
  FROM flight_data_2015
  GROUP BY DEST_COUNTRY_NAME
  """)
  val dataFrameWay = flightData2015
    .groupBy(Symbol("DEST_COUNTRY_NAME"))
    .count()

  sqlWay.explain
  dataFrameWay.explain

}
