package bbs.domain.internal.post.model

import org.joda.time.DateTime

trait PostFields {
  val title: String
  val content: String
  val thumbnail: String
  val createBy: String
  val updatedAt: Option[DateTime]
  val createdAt: Option[DateTime]
}
