
name := "stringmetric"

version := "0.1"

scalaVersion := "2.12.10"

organization := "com.moneyball.stringmetric"

pomExtra :=
	<url>https://moneyball.com.au/</url>
		<licenses>
			<license>
				<name>MIT</name>
				<distribution>repo</distribution>
			</license>
		</licenses>
		<scm>
			<url>git@github.com:moneyballau/stringmetric.git</url>
			<connection>scm:git:git@github.com:moneyballau/stringmetric.git</connection>
		</scm>
		<developers>
			<developer>
				<id>moneyballau</id>
				<name>Moneyball Devs</name>
				<url>https://moneyball.com/</url>
			</developer>
		</developers>

lazy val root = (project in file("."))
		.settings(
			credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
			publishMavenStyle := true,
			publishTo := Some("Sonatype" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"),
			resolvers ++= Seq(DefaultMavenRepository),
			scalaVersion := "2.12.10",
			version := "0.1.0"
	).aggregate(core, cli)

	lazy val core = (project in file("core"))
		.settings(
			libraryDependencies += "org.specs2" %% "specs2-junit" % "3.8.8" % "test",
			name := "stringmetric-core"
	)

	lazy val cli = (project in file("cli"))
		.settings(
			libraryDependencies += "org.specs2" %% "specs2-junit" % "3.8.8" % "test",
			name := "stringmetric-cli"
	).dependsOn(core)