package chatroom

import akka.actor._

class ChatRoom extends Actor {
  case class User(name: String)
  case class Subscribe(user: User)
  case class Unsubscribe(user: User)
  case class Post(msg: String)
  case class UserPost(user: User, post: Post)

  var session = Map.empty[User, ActorRef]

  def receive = {
    case Subscribe(user) => {
      val sessionUser = context.actorOf(Props(classOf[chatroom.User], user))
      session += user -> sessionUser
    }
    case Unsubscribe(user) =>
    case UserPost(user, post) =>
  }
}