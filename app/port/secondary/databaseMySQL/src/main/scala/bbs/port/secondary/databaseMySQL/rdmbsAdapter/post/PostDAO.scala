package bbs.port.secondary.databaseMySQL.rdmbsAdapter.post

import bbs.domain.internal.post.model.{Post, PostFields, PostId}
import scalikejdbc._
import skinny.orm.SkinnyCRUDMapper

case class PostDAO()
object PostDAO extends SkinnyCRUDMapper[PostRecord] {

  override lazy val tableName = "posts"
  override lazy val defaultAlias = createAlias("p")
  override lazy val primaryKeyFieldName = "postId"

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[PostRecord]): PostRecord = {
    PostRecord(
      postId = rs.get(n.postId),
            title = rs.get(n.title),
            content = rs.get(n.content),
            thumbnail = rs.get(n.thumbnail),
            createBy = rs.get(n.createBy),
            createdAt = rs.get(n.createdAt),
            updatedAt = rs.get(n.updatedAt)
    )
  }

}


