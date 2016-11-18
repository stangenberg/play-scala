name := """play-scala"""

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

lazy val extraResolvers = Seq(
  "Artima Maven Repository" at "http://repo.artima.com/releases",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/",
  Resolver.jcenterRepo
)
