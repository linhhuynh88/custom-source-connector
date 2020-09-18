package com.github.linhhuynh88.kafka.connect

import java.util

import com.github.linhhuynh88.kafka.connect.utils.ApplicationInfo
import org.apache.kafka.connect.source.{SourceRecord, SourceTask}

class MyConnectorTask extends SourceTask{
  override def start(props: util.Map[String, String]): Unit = {
    val offset = context.offsetStorageReader()
    println("Start connector")
  }

  override def poll(): util.List[SourceRecord] = {
    println("======================================")
    println("HelloWorld")
    println("======================================")
    null
  }

  override def stop(): Unit = {

  }

  override def version(): String = ApplicationInfo.version()
}
