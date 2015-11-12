libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6.5" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")
