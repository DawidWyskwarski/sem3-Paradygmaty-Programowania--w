import scala.annotation.tailrec

def insert[A](f:A=>A=>Boolean,xs:List[A],x:A):List[A] =
  xs match
    case Nil => x :: List()
    case h::t => if f(x)(h) then x :: h :: t else h :: insert(f,t,x)

def insertSort[A](f:A=>A=>Boolean,xs:List[A]): List[A] =
  @tailrec
  def insertRec(xs:List[A], result:List[A]):List[A] =
    xs match
      case Nil => result
      case h::t => insertRec(t,insert(f,result,h))

  insertRec(xs,List())

def merge[A](f:A=>A=>Boolean,xs:List[A],ys:List[A]):List[A] =
  (xs,ys) match
    case (Nil,_) => ys
    case (_,Nil) => xs
    case (hx::tx, hy::ty) =>
      if f(hx)(hy) then hx :: merge(f,tx,ys)
      else hy :: merge(f,xs,ty)

def mergeSort[A](f:A=>A=>Boolean,xs:List[A]): List[A] =
  xs match
    case Nil => List()
    case x::Nil => List(x)
    case h::t =>
      val (left,right) = xs.splitAt(xs.length/2)
      merge(f, mergeSort(f,left), mergeSort(f,right))


mergeSort( (x:Int)=>(y:Int)=>x<=y, List(432,7,2,464,8,53,25,9,43,4,5765,3,56,2))
//insertSort( (x:Int)=>(y:Int)=>x<=y, List(432,7,2,464,8,53,25,9,43,4,5765,3,56,2) )