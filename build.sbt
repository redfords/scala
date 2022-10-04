name := "scala_spark"

version := "0.0.1"

scalaVersion := "2.11.12"

resolvers += Resolver.sonatypeRepo("releases")

val sparkVersion = "2.4.0"
libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % sparkVersion % "provided"
  ,"org.apache.spark" %% "spark-sql" % sparkVersion % "provided"
  ,"org.apache.spark" %% "spark-yarn" % sparkVersion % "provided"
  ,"org.apache.spark" %% "spark-hive" % sparkVersion % "provided"
  ,"org.json4s" %% "json4s-native" % "3.5.0")

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}