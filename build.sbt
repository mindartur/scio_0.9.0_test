

name := "dataflow"
organization := "test.com"
version := "1.0"
scalaVersion := "2.12.12"


libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % scalaVersion.value,
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
)


scalacOptions ++= Seq("-Ypartial-unification")

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.24.0"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0" % "test"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.1.1"


libraryDependencies += "com.google.cloud" % "google-cloud-storage" % "1.111.2"

libraryDependencies += "com.github.luben" % "zstd-jni" % "1.4.5-4"


libraryDependencies ++= Seq(
  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "0.36.1" % Compile,
  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "0.36.1" % Provided // required only in compile-time
)


dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.10.2"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.10.2"
dependencyOverrides += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.10.2"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-annotations" % "2.10.2"
dependencyOverrides += "com.google.http-client" % "google-http-client-jackson2" % "1.34.0"
dependencyOverrides += "com.google.guava:" % "guava2" % "1.34.0"


libraryDependencies += "com.google.guava" % "guava" % "28.2-jre" exclude ("com.google.guava", "guava/bundles/")
libraryDependencies += "com.datadoghq" % "java-dogstatsd-client" % "2.10.3"
libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value

libraryDependencies ++= Seq(
  "com.spotify" %% "scio-core" % "0.9.3",
  "com.spotify" %% "scio-test" % "0.9.3" % Test,
  //  "org.apache.beam" % "beam-runners-direct-java" % "2.23.0",
  "org.apache.beam" % "beam-runners-google-cloud-dataflow-java" % "2.23.0"
)

libraryDependencies += "io.lemonlabs" %% "scala-uri" % "2.2.2"

