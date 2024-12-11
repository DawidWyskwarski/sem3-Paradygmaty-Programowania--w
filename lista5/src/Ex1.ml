type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lfrom k = LCons (k, lazy (lfrom (k+1)));;

let rec toLazyList = function
    [] -> LNil
  | x :: xs -> LCons(x, lazy (toLazyList xs));;

let rec ltake = function
    (0, _) -> []
  | (_, LNil) -> []
  | (n, LCons(x, lazy xs)) -> x :: ltake(n-1, xs) ;;


let rec lRepeat(n,llist) = 
  match (n,llist) with
  | (_,LNil) -> LNil
  | (n,LCons(h,lazy t)) -> 
      let rec repeat k =
        if k < n then
          LCons(h, lazy (repeat (k+1)) )
        else lRepeat(n, t)
      in repeat(0);;

ltake(10,lRepeat(3,(lfrom 1)))


