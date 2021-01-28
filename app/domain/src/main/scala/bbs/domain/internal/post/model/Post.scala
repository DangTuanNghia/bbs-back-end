package bbs.domain.internal.post.model

import bbs.utility.model.Entity
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import play.api.libs.json.{JsObject, JsPath, JsString, JsValue, Json, Reads, Writes}
import play.api.libs.functional.syntax.{ toFunctionalBuilderOps }



case class Post(identifier: PostId,
                title: String,
                content: String,
                thumbnail: String,
                createBy: String,
                override val createdAt: Option[DateTime],
                override val updatedAt: Option[DateTime]
               ) extends Entity[PostId] with PostFields {

}

object Post {
  implicit val jodaDateReads = Reads[Option[DateTime]](js =>
    js.validate[String].map[Option[DateTime]](dtString =>
      Option(DateTime.parse(dtString, DateTimeFormat.forPattern("yyyy-MM-dd")))))
  implicit val jodaDateWrites = new Writes[Option[DateTime]] {
    override def writes(o: Option[DateTime]): JsValue = {
      JsString(o.get.toString())
    }
  }

  implicit val postWrites: Writes[Post] = new Writes[Post] {
    val startSlice = 0
    val endSlice = 10

    override def writes(o: Post): JsObject = Json.obj(
      "identifier" -> o.identifier,
      "title" -> o.title,
      "content" -> o.content,
      "thumbnail" -> o.thumbnail,
      "createBy" -> o.createBy,
      "createdAt" -> o.createdAt.get.toString.substring(startSlice, endSlice),
      "updatedAt" -> (o.updatedAt match {
        case None => ""
        case Some(e) => e.toString.substring(startSlice, endSlice)
      }))
  }

  import bbs.domain.internal.post.model.PostId.customReads

  implicit val postReads: Reads[Post] = (
    (JsPath \ "identifier").read[PostId] and
      (JsPath \ "title").read[String] and
      (JsPath \ "content").read[String] and
      (JsPath \ "thumbnail").read[String] and
      (JsPath \ "createBy").read[String] and
      (JsPath \ "createdAt").read[Option[DateTime]] and
      (JsPath \ "updatedAt").read[Option[DateTime]]) (Post.apply _)
}
