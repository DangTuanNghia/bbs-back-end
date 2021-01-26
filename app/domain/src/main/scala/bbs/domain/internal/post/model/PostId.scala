package bbs.domain.internal.post.model

import bbs.utility.model.Identifier
import play.api.libs.json.{Json, Reads}

case class PostId(value: Int) extends Identifier[Int] {
  implicit def intToPostId(i: Int): PostId = PostId(i)
  implicit def postIdToInt(i: PostId): PostId = i.value

}

object PostId {
  implicit val readPostId = Reads[PostId](js =>
    js.validate[Int].map[PostId](dtString =>
      PostId(dtString)))

  implicit val customReads = Json.reads[PostId]
  implicit val customWrites = Json.writes[PostId]

}
