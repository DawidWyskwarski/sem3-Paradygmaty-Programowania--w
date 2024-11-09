def replaceNth[A](xs: List[A], n: Int, x: A): List[A]= (xs,n) match{
  case(Nil,_) => throw new Exception("Illegal value of n")
  case(_,n) if n < 0 => throw new Exception("Illegal value of n")

  case(_::tail, 0) => x::tail
  case(head::tail,_) => head :: replaceNth(tail,n-1,x)
}

replaceNth(List(1,2,3,4,5),4,"A")