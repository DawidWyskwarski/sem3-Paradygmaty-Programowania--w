def listLength[A](xs: List[A]): Int=
  if xs.isEmpty then
    0
  else
    1 + listLength(xs.tail)

listLength(List("a","a","a","b","c"))