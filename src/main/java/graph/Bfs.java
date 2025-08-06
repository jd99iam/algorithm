package graph;

import java.util.*;

public class Bfs {
    
    public static void main(String[] args) {
        HashMap<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "D", "E"));
        graph.put("B", Arrays.asList("A", "C", "D"));
        graph.put("C", Arrays.asList("B"));
        graph.put("D", Arrays.asList("A", "B"));
        graph.put("E", Arrays.asList("A"));


        List<String> result = bfs(graph, "A");

        for (String node : result){
            System.out.println(node);
        }


        
    }

    public static List<String> bfs(HashMap<String, List<String>> graph, String node){
        List<String> visited = new ArrayList<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
    
        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()){
            String current = queue.poll();            
            List<String> adjNodes = graph.get(current);

            for (String adjNode : adjNodes){
                if (!visited.contains(adjNode)){
                    visited.add(adjNode);
                    queue.offer(adjNode);
                }
            }

        }

        return visited;
    }
    
}
