type 'a graph = Graph of ('a -> 'a list) 

let g = Graph
    (function
      | 0 -> [3]
      | 1 -> [0;2;4]
      | 2 -> [1]
      | 3 -> []
      | 4 -> [0;2]
      | _ -> failwith("VERY BAD!!!!"));;

let depthSearch((Graph succ), start) =
  let rec tmp(visited, toVisit) =
    match toVisit with
    | [] -> List.rev visited
    | h::t ->
        if List.mem h visited then
          tmp(visited,t)
        else 
          tmp(h::visited,(succ h ) @ toVisit)
  in tmp([],[start]);;
    
    
depthSearch(g,4)