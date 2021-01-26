package bbs.domain.internal.post

import bbs.domain.internal.post.model.{Post, PostFields}

import scala.util.Try

trait PostRepository{
  def getAll: Try[List[Post]]
  def getPostById(id:Int): Try[Option[Post]]
}
