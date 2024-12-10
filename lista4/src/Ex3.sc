import scala.annotation.tailrec

sealed trait bt[+A]
case object Empty extends bt[Nothing]
case class Node[A](value:A,left:bt[A],right:bt[A]) extends bt[A]

val tt = Node(1,Node(2,Node(4,Empty,Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty))

def BFS[A](node:bt[A]): List[A] =
  @tailrec
  def tmp(queue:List[bt[A]], acc:List[A]):List[A] =
    queue match
      case Nil => acc.reverse
      case Empty::t => tmp(t,acc)
      case Node(v,l,r)::t => tmp(t ++ List(l,r),v::acc)
  tmp(List(node),List())

BFS(tt)