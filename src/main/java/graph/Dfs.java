package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dfs {
    public static void main(String[] args) {
        
        HashMap<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "D", "E"));
        graph.put("B", Arrays.asList("A", "C", "D"));
        graph.put("C", Arrays.asList("B"));
        graph.put("D", Arrays.asList("A", "B"));
        graph.put("E", Arrays.asList("A"));

        List<String> visited = dfs("A", new ArrayList<>(), graph);

        for (String node : visited){
            System.out.println(node);
        }


    }   
    
    public static List<String> dfs(String node, List<String> visited, HashMap<String, List<String>> graph){

        visited.add(node);

        for (String adjNode : graph.get(node)){
            if (!visited.contains(adjNode)){
                dfs(adjNode ,visited, graph);
            }
        }

        return visited;
    }
}
