name := """realEstatesPlay"""
organization := "in.kritter"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.3"

libraryDependencies += guice
libraryDependencies += javaJdbc
libraryDependencies += javaWs
libraryDependencies += filters

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"

