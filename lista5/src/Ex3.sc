sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

def lTree(n:Int):lBT[Int] =
  LNode(n, () => lTree(2*n) ,() => lTree(2*n+1))

def lBFS[A](lTree:lBT[A]): LazyList[A] =
  def tmp(queue:List[lBT[A]]): LazyList[A] =
    queue match
      case Nil => LazyList()
      case LEmpty :: tail => tmp( tail )
      case LNode(v,l,r) :: tail => v #:: tmp(tail ::: List(l(),r()) )
  tmp(List(lTree))

lBFS(lTree(1)).take(20).toList