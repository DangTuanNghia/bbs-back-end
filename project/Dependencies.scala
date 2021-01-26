import play.sbt.PlayImport._
import sbt._
object Dependencies {
  val defaultDependencies = Seq(jdbc, ehcache, ws, specs2 % Test, guice, evolutions)
  val addedDependencies = Seq(
    "mysql" % "mysql-connector-java" % "8.0.11",
    "org.skinny-framework" %% "skinny-orm" % "3.0.3",
    "org.skinny-framework" %% "skinny-task" % "3.0.3",
    "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.8.0-scalikejdbc-3.5",
    "joda-time" % "joda-time" % "2.10.9",
    "com.typesafe.play" %% "play-json-joda" % "2.9.2"
  )
}