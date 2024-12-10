def sumProd(xs:List[Int]): (Int,Int) =
  xs match
    case h::t => {val (s,p) = sumProd(t)
      (h+s,h*p)
    }
    case Nil => (0,1)

def sumProdFL(xs:List[Int]): (Int,Int) =
  xs.foldLeft(0,1)((acc,head) => (acc._1 + head, acc._2 * head))
  
sumProdFL(List(1,2,3,4,5)) 
sumProd(List(1,2,3,4,5))