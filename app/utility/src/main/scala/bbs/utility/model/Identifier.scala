package bbs.utility.model

trait Identifier[+A] extends Serializable {

  def value: A
}

