
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
  "com.adrianhurt" %% "play-bootstrap" % "1.0-P25-B3",
  "org.postgresql" % "postgresql" % "42.0.0",
  "com.zaxxer" % "HikariCP" % "2.6.1"

)
  libraryDependencies += evolutions


resolvers ++= Seq(
  "Apache" at "http://repo1.maven.org/maven2/",
  "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
  "Sonatype OSS Snasphots" at "http://oss.sonatype.org/content/repositories/snapshots"
)
routesGenerator := InjectedRoutesGenerator



fork in run := true