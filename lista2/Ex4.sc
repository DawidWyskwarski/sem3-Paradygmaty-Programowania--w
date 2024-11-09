def a(xs:List[Any]):Any = xs match{
  case (z::y::x::tail) => x
}

a(List(-2,-1,0,1,2))

def b(xs:List[Tuple]): Any = xs match{
  case _ :: (x,y) :: Nil => x
}

b(List((1,2),(0,1)))