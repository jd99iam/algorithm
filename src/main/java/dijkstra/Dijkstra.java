package dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] args) {
        // 가중치 그래프
        HashMap<Integer, List<Node>> graph = new HashMap<>();
        graph.put(1, List.of(Node.of(2, 2), Node.of(4, 1)));
        graph.put(2, List.of(Node.of(1, 2), Node.of(3, 1), Node.of(5, 9), Node.of(6, 6)));
        graph.put(3, List.of(Node.of(6, 4)));
        graph.put(4, List.of(Node.of(3, 3), Node.of(7, 5)));
        graph.put(5, List.of(Node.of(8, 1)));
        graph.put(6, List.of(Node.of(5, 3)));
        graph.put(7, List.of(Node.of(6, 7), Node.of(8, 9)));
        graph.put(8, List.of());

        System.out.println(dijkstra(1, 8, graph));

    }

    public static int dijkstra(int start, int end, HashMap<Integer, List<Node>> graph) {
        // 힙
        PriorityQueue<Node> heap = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.cost, n2.cost));
        // 인덱스 비용
        HashMap<Integer, Integer> costs = new HashMap<>();

        heap.offer(new Node(start, 0));

        while (!heap.isEmpty()) {
            Node current = heap.poll();
            if (!costs.containsKey(current.index)) {
                costs.put(current.index, current.cost);
                for (Node adjNode : graph.get(current.index)) {
                    heap.offer(Node.of(adjNode.index, current.cost + adjNode.cost));
                }
            }
        }
        return costs.get(end);
    }

    public static class Node {
        public int index;
        public int cost;

        public Node(int value, int cost) {
            this.index = value;
            this.cost = cost;
        }

        public static Node of(int index, int cost) {
            return new Node(index, cost);
        }
    }
}
