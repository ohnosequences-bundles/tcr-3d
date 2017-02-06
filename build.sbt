name          := "tcr3d"
organization  := "ohnosequences-bundles"
description   := "TCR-3D R package bundle"

bucketSuffix  := "era7.com"

libraryDependencies += "ohnosequences" %% "statika" % "2.0.0"

wartremoverErrors in (Compile, compile) := Seq()

releaseOnlyTestTag := "ohnosequencesBundles.test.ReleaseOnlyTest"
