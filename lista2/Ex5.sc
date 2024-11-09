import scala.annotation.tailrec

@tailrec
def initSegment[A](xs: List[A], ys: List[A]): Boolean= (xs,ys) match{
  case (Nil,_) => true
  case (xHead::xTail, yHead::yTail) if xHead == yHead => initSegment(xTail,yTail)
  case (xHead::xTail, yHead::yTail) if xHead != yHead => false
  case (_, Nil) => false;
}

initSegment(List(1,2,3,4), List(4,3,2,1))