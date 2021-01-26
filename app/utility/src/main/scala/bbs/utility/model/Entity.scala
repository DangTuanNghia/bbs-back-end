package bbs.utility.model

trait Entity[ID <: Identifier[_]]
  extends RecordTimestamp {
  val identifier: ID
}

