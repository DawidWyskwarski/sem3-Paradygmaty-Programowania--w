import scala.annotation.tailrec

def power(a:Double, n:Int): Double=
  if n==0 then
    1
  else
    a*power(a,n-1)

val epsilon=power(0.1,15)

def root3(a:Double):Double=
  @tailrec
  def rooting(a:Double, x:Double): Double =
    if (power(x,3) - a).abs <= epsilon * a.abs then
      x
    else
      rooting(a,x + ( a / power(x,2) - x ) / 3 )

  if a.abs > 1 then
    rooting(a,a/3)
  else
    rooting(a,a)

root3(-0.5)