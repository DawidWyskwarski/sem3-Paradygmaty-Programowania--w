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

let calcI node =
  let rec cal(node,level) =
    match node with
    | Empty -> 0
    | Node(_,l,r) -> 
        match (l,r) with
        | (Empty,Empty) -> 0
        | _ -> level + cal(l,level+1) + cal(r,level+1)
  in cal(node,0);;
    
let calcE node = 
  let rec cal(node,level) = 
    match node with
    | Empty -> 0
    | Node(_,l,r) -> 
        match (l,r) with
        | (Empty,Empty) -> level
        | _ -> cal(l,level+1) + cal(r,level+1)
  in cal(node,0);;
    
calcI tt;;
calcE tt
          
          
          
          