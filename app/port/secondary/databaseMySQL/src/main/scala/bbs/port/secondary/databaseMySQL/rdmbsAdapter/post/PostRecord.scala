package bbs.port.secondary.databaseMySQL.rdmbsAdapter.post

import bbs.domain.internal.post.model.PostId
import bbs.utility.model.RecordTimestamp
import org.joda.time.DateTime

case class PostRecord(
                       postId: Int,
                       title: String,
                       content: String,
                       thumbnail: String,
                       createBy: Int,
                       override val createdAt: Option[DateTime],
                       override val updatedAt: Option[DateTime],
                     ) extends RecordTimestamp
