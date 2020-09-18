package com.github.linhhuynh88.kafka.connect.utils

import java.util.Properties

object ApplicationInfo {
  private val props = new Properties()
  private val application = this.getClass.getClassLoader.getResourceAsStream("application.properties")
  props.load(application)

  def version() = props.getProperty("version")

  def artifact():String = props.getProperty("artifact")
}
