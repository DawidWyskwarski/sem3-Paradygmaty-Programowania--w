import scala.annotation.tailrec

sealed trait Graphs[+A]
case class Graph[A](succ: A=>List[A]) extends Graphs[A]

val g = Graph((i:Int)=>
  i match
    case 0 => List(3)
    case 1 => List(0,2,4)
    case 2 => List(1)
    case 3 => Nil
    case 4 => List(0,2)
    case _ => throw new Exception("REALLY BAD!!!!")
)

def depthSearch[A](graph:Graph[A],start:A): List[A] =
  @tailrec
  def tmp(visited:List[A], toVisit:List[A]): List[A] =
    toVisit match
      case Nil => visited.reverse
      case h::t =>
        if visited.contains(h) then
          tmp(visited,t)
        else
          tmp(h::visited,graph.succ(h) ::: toVisit)
  tmp(List(), List(start) )

depthSearch(g,2)

