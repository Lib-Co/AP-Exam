import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ShortestPath {

    private HashMap<String, Node> nodes;

    public ShortestPath() {
        nodes = new HashMap<>();
    }

    public String nodesInShortestPath(String start, String end) {
        Node s = nodes.get(start);
        Node e = nodes.get(end);
        ArrayList<Node> nodesInShortestPath = new ArrayList<>();

        nodesInShortestPath.add(e);
        Node currNode = e;
        while (!currNode.equals(s)) {
            EdgeList edgeList = currNode.getEdges();
            for (int i = 0; i < edgeList.length(); i++) {
                Node temp = edgeList.get(i).getEndNode();
                int distance = edgeList.get(i).getDistance();
                if ((temp.getShortestDistance() + distance) == currNode.getShortestDistance()) {
                    currNode = temp;
                    nodesInShortestPath.add(currNode);
                }
            }
        }

        Collections.reverse(nodesInShortestPath);
        String result = "[";
        for (Node n : nodesInShortestPath) {
            result += n.getLabel();
        }
        result += "]";
        return result;
    }


    public int shortestPath(String start, String end) {
        Node startNode = nodes.get(start);
        Node endNode = nodes.get(end);
        PriorityQueue queue = new PriorityQueue();

        startNode.setAsStartNode();
        queue.add(0, startNode);

        while (queue.hasNext()) {
            Node currNode = queue.getNextHighestPriorityNode();
            if (endNode.equals(currNode)) {
                return endNode.getShortestDistance();
            } else {
                for (int i = 0; i < currNode.getEdges().length(); i++) {
                    Edge edge = currNode.getEdges().get(i);
                    Node n = edge.getEndNode();
                    if (!n.hasBeenVisited()) {
                        int distance = edge.getDistance();
                        int currDistance = currNode.getShortestDistance();
                        int currShortestDistance = distance + currDistance;
                        if (currShortestDistance < n.getShortestDistance()) {
                            n.updateShortestDistance(edge);
                        }
                        queue.add(n.getShortestDistance(), n);
                    }
                }
                currNode.setVisited();
            }
        }
        return 0;
    }


    public void readInNodes(String file) {
        try {
            File f = new File(file);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] info = s.split(" ");
                if (!nodes.containsKey(info[0])) {
                    nodes.put(info[0], new Node(info[0]));
                }
                if (!nodes.containsKey(info[1])) {
                    nodes.put(info[1], new Node(info[1]));
                }
                Node n1 = nodes.get(info[0]);
                Node n2 = nodes.get(info[1]);
                int i = Integer.valueOf(info[2]);
                Edge e = new Edge(i, n1, n2);
                nodes.get(info[0]).addEdge(e);
                Edge e2 = new Edge(i, n2, n1);
                nodes.get(info[1]).addEdge(e2);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printGraph() {
        System.out.println("Graph");
        for (String k : nodes.keySet()) {
            System.out.println(nodes.get(k));
        }
    }
}
