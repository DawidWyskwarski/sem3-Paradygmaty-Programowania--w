def sqrList(xs: List[Int]): List[Int] =
  if xs.isEmpty then
    List()
  else List(xs.head * xs.head) ::: sqrList(xs.tail)

sqrList(List(0,-1,3,-5))