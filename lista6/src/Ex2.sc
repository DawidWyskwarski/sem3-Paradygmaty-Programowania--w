def swap(array:Array[Int], i:Int, j:Int): Unit =
  val tmp = array(i)
  array(i) = array(j)
  array(j) = tmp

def partition(array: Array[Int], left:Int, right:Int): (Int,Int) =
  var i = left
  var j = right

  val pivot = array( (left+right)/2 )

  while (i<=j) {
    while(array(i) < pivot){ i+=1 }
    while(pivot < array(j)) { j-=1 }

    if i <= j then
      swap(array, i, j)
      i+=1
      j-=1
  }
  (i,j)

def quick(array: Array[Int], left:Int, right:Int): Unit =
  if left < right then
    var (i,j) = partition(array,left,right)

    if j - left < right - i then
      quick(array,left,j)
      quick(array,i,right)
    else
      quick(array,i,right)
      quick(array,left,j)

def quickSort(array:Array[Int]): Unit =
  quick(array,0,array.length-1)

var arr = Array(4,8,1,12,7)

quickSort(arr)

println(arr.toList)