name := "untitled"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.2.23",
  "org.apache.spark" % "spark-streaming_2.10" % "2.2.3",
  "org.apache.spark" %% "spark-sql" % "3.1.2"
)