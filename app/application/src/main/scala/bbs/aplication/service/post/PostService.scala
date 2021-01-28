package bbs.aplication.service.post

import bbs.domain.internal.post.PostRepository
import bbs.domain.internal.post.model.{Post, PostFields, PostId}
import javax.inject.{Inject, Singleton}

import scala.util.Try

@Singleton
class PostService @Inject()(postRepository: PostRepository){
  def getAllPosts: Try[List[Post]] = postRepository.getAll
  def getPostById(id: Int): Try[Option[Post]] = postRepository.getPostById(id)
  def createdPost(post: Post): Long = postRepository.createdPost(post)
//  def updatedPost(id:Int,post: Post) = postRepository.updatedPost(id,post)
}
