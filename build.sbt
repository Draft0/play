
name := """play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  jdbc,
filters,
  "com.efsavage.twitter.bootstrap" % "bootstrap-maven" % "2.3.1",
  "org.postgresql" % "postgresql" % "42.0.0",
  "com.zaxxer" % "HikariCP" % "2.6.1",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % "test",
  "org.avaje.ebean" % "ebean" % "9.5.1",
  "org.mindrot" % "jbcrypt" % "0.3m"


)
  libraryDependencies += evolutions


resolvers ++= Seq(
  "Apache" at "http://repo1.maven.org/maven2/",
  "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
  "Sonatype OSS Snasphots" at "http://oss.sonatype.org/content/repositories/snapshots"
)
routesGenerator := InjectedRoutesGenerator



fork in run := true