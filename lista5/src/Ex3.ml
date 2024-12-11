type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lfrom k = LCons (k, lazy (lfrom (k+1)));;

let rec toLazyList = function
    [] -> LNil
  | x :: xs -> LCons(x, lazy (toLazyList xs));;

let rec ltake = function
    (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x, lazy xs)) -> x :: ltake(n-1, xs);; 


type 'a lBT = LEmpty | LNode of 'a * (unit ->'a lBT) * (unit -> 'a lBT);;

let rec lTree n =
  LNode(n, (function () -> lTree(2*n)), (function () ->  lTree(2*n + 1) ));;

let lBFS(tree) = 
  let rec tmp(queue) = 
    match queue with 
    | [] -> LNil
    | LEmpty :: tail -> tmp(tail)
    | LNode(v,l,r) :: tail -> LCons(v, lazy (tmp(tail @ [l(); r()])))
  in tmp([tree]);;
    
ltake(10,lBFS(lTree(10)))     
        
        
        
        
        