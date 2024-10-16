def palindrome[A] (xs: List[A]): Boolean =
  if xs == xs.reverse then 
    true
  else 
    false

palindrome(List(0,1,1,1,2,0))