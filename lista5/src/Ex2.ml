type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lfrom k = LCons (k, lazy (lfrom (k+1)));;

let rec toLazyList = function
    [] -> LNil
  | x :: xs -> LCons(x, lazy (toLazyList xs));;

let rec ltake = function
    (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x, lazy xs)) -> x :: ltake(n-1, xs) ;;


let fib = 
  let rec fibr a b =
    LCons (a, lazy (fibr b (a + b) ) )
  in fibr 0 1 ;;

ltake (10, fib)