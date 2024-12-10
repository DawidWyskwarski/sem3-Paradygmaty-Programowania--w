sealed trait bt[+A]
case object Empty extends bt[Nothing]
case class Node[A](value:A,left:bt[A],right:bt[A]) extends bt[A]

val tt = Node(1,Node(2,Node(4,Empty,Empty),Empty),Node(3,Node(5,Empty,Node(6,Empty,Empty)),Empty))

def calcI[A](node:bt[A]):Int =
  def tmp(node:bt[A],level:Int):Int =
    node match
      case Empty => 0
      case Node(_,l,r) => (l,r) match
        case (Empty,Empty) => 0
        case _ => level + tmp(l,level+1) + tmp(r,level+1)
  tmp(node,0)

def calcE[A](node:bt[A]):Int =
  def tmp(node:bt[A],level:Int):Int =
    node match
      case Empty => 0
      case Node(_,l,r) => (l,r) match
        case (Empty,Empty) => level
        case _ => tmp(l,level+1) + tmp(r,level+1)
  tmp(node,0)

calcI(tt)
calcE(tt)