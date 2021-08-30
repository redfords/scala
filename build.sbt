name := "untitled"

version := "0.1"

scalaVersion := "2.13.6"

val sparkVersion = "3.1.1"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.2.23",
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion

)