

name := "knolcart_assignment"

lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.3",
  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"
    coverageEnabled := true
)



lazy val checkout_Service = project.
  settings(
  commonSettings
)

lazy val inventory_Service = project.
  settings(
  commonSettings
)

lazy val accountServices = project.
  settings(
  commonSettings
)
lazy val api_resources = project.
  dependsOn(checkout_Service,inventory_Service,accountServices)
  .settings(
    commonSettings
  )

lazy val knolcart_dashboard = project.
  dependsOn(api_resources).
  settings(
    commonSettings
  )

lazy val root = (project in file(".")).
  aggregate(accountServices, api_resources, checkout_Service, inventory_Service, knolcart_dashboard )
    