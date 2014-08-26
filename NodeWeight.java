import java.util.ArrayList;


public class NodeWeight {
	private int weight;
	private Node node;
	private Link myRoot;
	private ArrayList<Link>root;
	public NodeWeight(int weight,Node node,Link link){
		root=new ArrayList<>();
		root.add(link);
		myRoot=link;
		this.weight=weight;
		this.node=node;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public ArrayList<Link> getLinks() {
		return root;
	}
	public void setLinks(ArrayList<Link> links) {
		this.root = links;
	}
	public Link getMyRoot() {
		return myRoot;
	}
	public void setMyRoot(Link myRoot) {
		this.myRoot = myRoot;
	}
	public ArrayList<Link> getRoot() {
		return root;
	}
	public void setRoot(ArrayList<Link> root) {
		this.root = root;
	}
	
	
}
