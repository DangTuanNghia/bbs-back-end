package module
import bbs.domain.internal.post.PostRepository
import bbs.port.secondary.databaseMySQL.rdmbsAdapter.post.PostRepositoryOnJDBCImpl
import com.google.inject.AbstractModule


class BBSModule extends AbstractModule {
  lazy val postRepository: PostRepository = new PostRepositoryOnJDBCImpl
  override def configure(): Unit = {
    bind(classOf[PostRepository]).toInstance(postRepository)
  }
}
