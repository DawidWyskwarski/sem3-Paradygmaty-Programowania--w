def fib(n:Int):Int =
  if n==0 || n==1 then
    n
  else
    fib(n-1) + fib(n-2)

def fibTail(n:Int):Int =
  if n==0 then
    0
  else
    def tmp(n:Int, prev:Int, cur:Int):Int =
      if n>0 then
        tmp(n-1,cur, cur+prev )
      else
        cur

    tmp(n-1,0,1)


fib(42)
fibTail(0)