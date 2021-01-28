package bbs.port.secondary.databaseMySQL.rdmbsAdapter.post

import bbs.domain.internal.post.PostRepository
import bbs.domain.internal.post.model.{Post, PostFields, PostId}
import javax.inject.Singleton
import skinny.Pagination

import scala.util.Try

@Singleton
class PostRepositoryOnJDBCImpl(protected[this] val dao: PostDAO = new PostDAO) extends PostRepository {
 protected def convertToEntity(record: PostRecord): Post = {
    Post(
      identifier = PostId(record.postId),
      title = record.title,
      content = record.content,
      thumbnail = record.thumbnail,
      createBy = record.createBy,
      createdAt = record.createdAt,
      updatedAt = record.updatedAt
    )
  }
  override def getAll: Try[List[Post]] = Try{ PostDAO.findAll().map(convertToEntity) }

  override def getPostById(id: Int): Try[Option[Post]] = Try{Some(convertToEntity(PostDAO.findById(id).get))}

  override def createdPost(post: Post): Long = {
    PostDAO.createWithAttributes(
    'postId -> 0,
    'title-> post.title,
    'content -> post.content,
    'thumbnail -> post.thumbnail,
    'createBy -> post.createBy,
    'createdAt -> post.createdAt,
    'updatedAt -> post.updatedAt
  )}

//  override def updatedPost(id: Int, post: Post): Long = {
//    PostDAO.updateById(id).withAttributes(
//      'postId -> post.identifier.value,
//      'title ->post.title,
//      'content -> post.content,
//      'thumbnail -> post.thumbnail,
//      'createBy -> post.createBy,
//      'createdAt -> post.createdAt,
//      'updatedAt -> post.updatedAt
//    )
//  }
}
