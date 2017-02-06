package ohnosequencesBundles.statika

import ohnosequences.statika._

abstract class TCR3D(val version: String) extends Bundle() { tcr3d =>

  val folder  = s"TCR3D_${tcr3d.version}"
  val tarball = tcr3d.folder + ".tar.gz"

  lazy val installR = cmd("yum")("install", "-y", "R")
  lazy val getTarball = cmd("aws")("s3", "cp",
    s"https://s3-eu-west-1.amazonaws.com/resources.ohnosequences.com/tcr3d/${tcr3d.version}/${tcr3d.tarball}",
    "."
  )
  lazy val extractTarball = cmd("tar")("-xvzf", tcr3d.tarball)
  lazy val installPackage = cmd("R")("CMD", "INSTALL", tcr3d.folder)

  def instructions: AnyInstructions =
    installR -&-
    getTarball -&-
    extractTarball -&-
    installPackage

}
