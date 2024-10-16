import scala.annotation.tailrec

def flatten1[A] (xss:List[List[A]]): List[A]=
  if xss.isEmpty then List() else xss.head ::: flatten1(xss.tail) 


flatten1(List(List(5,4,6),List(-3,-4,-5),List(),List(0,0,0)))
