package hello

import io.scalaland.chimney.dsl._

import scala.beans.BeanProperty

case class Entity(field1: String, field2: Option[String])

class AnotherEntity {
  @BeanProperty
  var field1: String = _

  @BeanProperty
  var field2: String = _

  override def toString = {
    s"$field1 :: $field2"
  }
}

object Main extends App {
  val entity = Entity("1", Some("2"))

  val anotherEntity = entity.into[AnotherEntity]
    .withFieldComputed(_.field2, _.field2.orNull)
    .enableBeanSetters
    .transform

  println(anotherEntity)
}
