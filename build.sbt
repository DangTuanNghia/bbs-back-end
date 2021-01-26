import sbt._
import Keys._
import Dependencies._
import com.typesafe.config._
name := "backend_bbs"
version := "1.0"
lazy val `backend_bbs` = (project in file(".")).enablePlugins(PlayScala)
resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
scalaVersion := "2.12.2"


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

lazy val commonSettings = Seq(
  scalaVersion := "2.12.2",
  scalaSource in Compile := baseDirectory.value / "src" / "main" / "scala",
  scalaSource in Test := baseDirectory.value / "src" / "test" / "scala",
  resourceDirectory in Compile := baseDirectory.value / "src" / "main" / "resources",
  resourceDirectory in Test := baseDirectory.value / "src" / "test" / "resources"
)
lazy val root = (project in file("."))
  .enablePlugins(PlayScala, SbtWeb)
  .disablePlugins(PlayLayoutPlugin)
  .aggregate(application, domain, port, utility)
  .dependsOn(application, domain, port, utility)
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Dependencies.defaultDependencies)
lazy val application = (project in file("app/application"))
  .enablePlugins(PlayScala, SbtWeb)
  .disablePlugins(PlayLayoutPlugin)
  .disablePlugins(PlayLayoutPlugin)
  .dependsOn(utility , domain)
  .settings(commonSettings: _*)
lazy val domain = (project in file("app/domain"))
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin)
  .dependsOn(utility)
  .settings(commonSettings: _*)
lazy val utility = (project in file("app/utility"))
  .settings(commonSettings: _*)
  .enablePlugins(PlayScala)
lazy val port = (project in file("app/port"))
  .aggregate(portWebService, portDatabase)
  .dependsOn(portWebService, portDatabase)
  .settings(commonSettings: _*)
lazy val portWebService = (project in file("app/port/primary/webService"))
  .enablePlugins(PlayScala, SbtWeb)
  .disablePlugins(PlayLayoutPlugin)
  .dependsOn(utility, application)
  .settings(commonSettings: _*)
lazy val portDatabase = (project in file("app/port/secondary/databaseMySQL"))
  .dependsOn(utility, application)
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= addedDependencies)