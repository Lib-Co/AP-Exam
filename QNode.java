
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
        if (this.next == null) {
            if (this.priority <= n.priority) {
                this.next = n;
                n.previous = this;
            } else {
                QNode temp = this.previous;
                this.previous = n;
                n.next = this;
                n.previous = temp;
                temp.next = n;
            }
            return;
        }
        if (next.getPriority() > priority) {
            next.addQNode(n);
        }
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

