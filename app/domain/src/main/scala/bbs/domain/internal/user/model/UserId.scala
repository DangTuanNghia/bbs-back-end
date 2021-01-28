package bbs.domain.internal.user.model
import bbs.utility.model.Identifier
import play.api.libs.json.{Json, Reads}

case class UserId(value: Int) extends Identifier[Int] {
  implicit def intToUserId(i: Int): UserId = UserId(i)
  implicit def userIdToInt(i: UserId): UserId = i.value

}

object UserId {
  implicit val readUserId = Reads[UserId](js =>
    js.validate[Int].map[UserId](dtString =>
      UserId(dtString)))

  implicit val customReads = Json.reads[UserId]
  implicit val customWrites = Json.writes[UserId]
}