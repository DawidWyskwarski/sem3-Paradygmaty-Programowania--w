def sqrList(xs: List[Int]): List[Int] =
  if xs.isEmpty then
    List()
  else List(xs.head * xs.head) ::: sqrList(xs.tail)

val sqrList2: List[Int] => List[Int] = xs =>
        if xs.isEmpty then
                List()
        else
                List(xs.head * xs.head) ::: sqrList2(xs.tail)

sqrList(List(0,-1,3,-5))
sqrList2(List(0,-1,3,-5))