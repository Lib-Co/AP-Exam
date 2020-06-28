import com.sun.source.tree.BreakTree;

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
        if (priority >= root.getPriority()) {
            root.addQNode(new QNode(priority, n));
            return;
        }
        QNode temp = root;
        root = new QNode(priority, n);
        root.setNext(temp);
        temp.setPrevious(root);
    }

    public Node getNextHighestPriorityNode() {
        if (root.getNode().hasBeenVisited()) {
            root = root.getNext();
        }
        return root.getNode();
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