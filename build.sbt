enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

name := "Screenshot-Grabber"

version := "0.0.3"

scalaVersion := "2.11.5"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= {
  val akkaV       = "2.3.9"
  val akkaStreamV = "1.0-M3"
  val scalaTestV  = "2.2.1"
  Seq(
    "com.typesafe.akka" %% "akka-actor"                        % akkaV,
    "com.typesafe.akka" %% "akka-stream-experimental"          % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-core-experimental"       % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-experimental"            % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-testkit-experimental"    % akkaStreamV,
    "org.scalatest"     %% "scalatest"                         % scalaTestV % "test"
  )
}

daemonUser in Docker := "root"

dockerExposedPorts in Docker += 5000

dockerExposedVolumes in Docker += "/var/screenshots"

dockerBaseImage in Docker := "eudgee/phantomjs"

dockerRepository in Docker := Some("dh.livetex.ru/livetex")

dockerUpdateLatest in Docker := true

Revolver.settings
