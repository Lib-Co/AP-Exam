
public class PriorityQueue {
    private QNode root;

    public PriorityQueue() {
        root = null;
    }

    public void add(int priority, Node n) {
        // question 3
        if (root == null) {
            root = new QNode(priority, n);
            return;
        }
        root.addQNode(new QNode(priority, n));

    }

    public Node getNextHighestPriorityNode() {
        // question 3
        root.getNext().getNode();
        return null;
    }

    public boolean hasNext() {
        return (root != null);
    }

    public String toString() {
        if (root == null) {
            return "(empty)";
        }
        return root.toString();
    }
}