
public class QNode {
    private int priority;
    private QNode next;
    private QNode previous;
    private Node node;

    public QNode(int priority, Node n) {
        this.priority = priority;
        this.node = n;
        next = null;
        previous = null;
    }

    public Node getNode() {
        return node;
    }

    public void addQNode(QNode n) {
        if(n.next == null) {
        }
        if (n.next != null && n.priority > n.getNext().getPriority()) {
            n.getNext().addQNode(n);
        }
        QNode temp = this.next;
        this.next = n;
        this.next.next = temp;
    }


    public int getPriority() {
        return priority;
    }

    public void setPrevious(QNode p) {
        previous = p;
    }

    public QNode getPrevious() {
        return previous;
    }

    public void setNext(QNode n) {
        next = n;
    }

    public QNode getNext() {
        return next;
    }

    public String toString() {
        String s = node.getLabel() + " (" + priority + ") : ";
        if (next != null) {
            s += next.toString();
        }
        return s;
    }

}

