def fib: LazyList[Int] =
  def fibRec(a:Int,b:Int):LazyList[Int] =
    a #:: fibRec(b,a + b)
  fibRec(0,1)  
  
fib.take(4).toList  