def replicate[A] (x:A, n: Int): List[A]=
  if n == 0 then
    List()
  else replicate(x,n-1) ::: List(x)

replicate("la",4)