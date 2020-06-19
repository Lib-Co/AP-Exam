
public class PriorityQueue {
	private QNode root;
	
	public PriorityQueue() {
		root = null;
	}
	
	public void add(int priority, Node n) {
		// question 3
	}
	
	public Node getNextHighestPriorityNode() {
		// question 3
		return null;
	}
	
	public boolean hasNext() {
		return (root!=null);
	}
	
	public String toString() {
		if(root == null) {
			return "(empty)";
		}
		return root.toString();
	}
}