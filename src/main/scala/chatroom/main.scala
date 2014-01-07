package chatroom

import akka.actor.Actor
import akka.actor.Props

object main extends Actor {
  case class User(name: String)
  case class Subscribe(user: User)

  def main(args: Array[String]): Unit = {
    println("Starting chat room!")
    val chatRoom = context.actorOf(Props[ChatRoom], "chatroom")

    chatRoom ! Subscribe(User("bob"))

    println("Shutting down")
    context.stop(self)
  }

  def receive = {
    case _ =>
  }
}