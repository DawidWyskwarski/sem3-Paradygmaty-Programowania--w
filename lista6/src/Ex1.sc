def whileLoop(condition: => Boolean, body: => Unit): Unit =
  if condition then
    body
    whileLoop(condition, body)

var count = 0
val condition = () => count < 3
val process = () => {println(count); count+=1}

whileLoop(condition(), process())