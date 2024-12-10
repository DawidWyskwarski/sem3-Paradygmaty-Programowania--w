def lRepeat[A](k:Int)(xs:LazyList[A]): LazyList[A] =
  def repeat(x:A,count:Int):LazyList[A] =
    count match
      case 0 => LazyList()
      case n => x #:: repeat(x,count-1)

  def repeatList(list:LazyList[A]): LazyList[A] =
    list match
      case LazyList() => LazyList()
      case h #:: t => repeat(h,k) #::: repeatList(t)

  repeatList(xs)

lRepeat(3)(LazyList('a', 'b', 'c', 'd')).toList

lRepeat(3)(LazyList.from(1)).take(15).toList

lRepeat(3)(LazyList()).take(15).toList