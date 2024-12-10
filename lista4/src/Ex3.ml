type 'a bt = Empty | Node of 'a * 'a bt * 'a bt
                               
let tt = Node(1,
              Node(2,
                   Node(4,
                        Empty,
                        Empty),
                   Empty),
              Node(3,
                   Node(5,
                        Empty,
                        Node(6,
                             Empty,
                             Empty)),
                   Empty));;

let bfs node =
  let rec tmp(queue,acc) = 
    match queue with
    | [] -> List.rev acc
    | Empty::t -> tmp(t,acc)
    | Node(v,l,r)::t -> tmp(t @ [l;r], v::acc) 
  
  in tmp([node],[]);;

bfs tt
                          