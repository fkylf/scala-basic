package com.horizonio.spark.core

import java.util.Properties

import com.horizonio.spark.core.kafkaEx.SwampEncoder
import kafka.producer.{KeyedMessage, Producer, ProducerConfig}
import kafka.serializer.StringEncoder


/**
  * Created by zqh  on 2016/9/1
  */
trait KafkaBaseAppT {

  def getProducerConfig[T](brokerAddr: String): Properties = {
    val props = new Properties()
    props.put("metadata.broker.list", brokerAddr)
    props.put("serializer.class", classOf[SwampEncoder[T]].getName)
    props.put("key.serializer.class", classOf[StringEncoder].getName)
    props
  }

  def getProducerConfigDefaultserializer(brokerAddr: String): Properties = {
    val props = new Properties()
    props.put("metadata.broker.list", brokerAddr)
    props.put("serializer.class", "kafka.serializer.StringEncoder")
    props.put("key.serializer.class", "kafka.serializer.StringEncoder")
    props
  }

  def getKafkaProducer(brokerAddr: String): Producer[String, String] = {
    val producer = new Producer[String, String](new ProducerConfig(getProducerConfigDefaultserializer(brokerAddr)));
    producer
  }

  def sendMessagesDefaultserializer(topic: String, messages: List[String], producer: Producer[String, String]) {
    producer.send(messages.map {
      new KeyedMessage[String, String](topic, null, _)
    }: _*)
  }

  def sendMessages[T](topic: String, messages: List[T], brokerAddr: String) {
    val producer = new Producer[String, T](new ProducerConfig(getProducerConfig(brokerAddr)))
    producer.send(messages.map {
      new KeyedMessage[String, T](topic, null, _)
    }: _*)
    producer.close()
  }
}
