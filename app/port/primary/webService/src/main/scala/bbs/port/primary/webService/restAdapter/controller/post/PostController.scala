package bbs.port.primary.webService.restAdapter.controller.post

import bbs.aplication.service.post.PostService
import javax.inject.Inject
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

class PostController @Inject() (ps: PostService)(ec: ExecutionContext)(cc: ControllerComponents) extends AbstractController(cc) {

  def getAllPost: Action[AnyContent] = Action {
    ps.getAllPosts match {
      case Failure(e) => Ok(e.getMessage)
      case Success(value) => Ok(Json.toJson(value))
    }
  }

  def findPotsById(id: Int) = Action{
    ps.getPostById(id) match {
      case Failure(e) => Ok(e.getMessage)
      case Success(value) => Ok(Json.toJson(value))
    }
  }

}

