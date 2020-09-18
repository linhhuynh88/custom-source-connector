package com.github.linhhuynh88.kafka.connect

import java.util
import java.util.Collections

import com.github.linhhuynh88.kafka.connect.ConnectorConstant._
import com.github.linhhuynh88.kafka.connect.utils.ApplicationInfo
import org.apache.kafka.common.config.ConfigDef
import org.apache.kafka.common.config.ConfigDef.{Importance, Type}
import org.apache.kafka.connect.connector.Task
import org.apache.kafka.connect.source.SourceConnector
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

class MyConnectorSource extends SourceConnector{
  val LOGGER = LoggerFactory.getLogger(getClass)

  var connectorConfig: util.Map[String,String] = null
  override def start(props: util.Map[String, String]): Unit = {
    LOGGER.info(s"Start ${ApplicationInfo.artifact()}")
    println("======================================")
    connectorConfig = props
    props.asScala.foreach(
      x => println(s"${x._1} = ${x._2}")
    )
    println("======================================")

  }

  override def taskClass(): Class[_ <: Task] = classOf[MyConnectorTask]

  override def taskConfigs(maxTasks: Int): util.List[util.Map[String, String]] = {
    Collections.singletonList(connectorConfig)
  }

  override def stop(): Unit = {

  }

  override def config(): ConfigDef = {
    new ConfigDef()
      .define(BATCH_SIZE_NAME,Type.LONG,Importance.LOW,null)
      .define(TOPIC_NAME,Type.STRING,Importance.HIGH,null)
      .define(MESSAGE_NAME,Type.STRING,Importance.MEDIUM,null)
  }

  override def version(): String = ApplicationInfo.version()
}
