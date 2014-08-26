import java.util.*;


public class Node implements Cloneable {
	private ArrayList<Link> intoList;
	private ArrayList<Link> outList;
    private int nodeID;
    public Node(int ID){
    	intoList=new ArrayList<>();
    	outList=new ArrayList<>();
    	nodeID=ID;
    }
    public void addIntoLink(Link link){
    	intoList.add(link);
    }
    public void addOutList(Link link){
    	outList.add(link);
    }
	public ArrayList<Link> getIntoList() {
		return intoList;
	}
	public void setIntoList(ArrayList<Link> intoList) {
		this.intoList = intoList;
	}
	public ArrayList<Link> getOutList() {
		return outList;
	}
	public void setOutList(ArrayList<Link> outList) {
		this.outList = outList;
	}
	public int getNodeID() {
		return nodeID;
	}
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}
	public Node clone()throws CloneNotSupportedException{
		Node cloned=(Node)super.clone();
		cloned.nodeID=nodeID;
		cloned.outList=null;
		cloned.intoList=null;
		return cloned;
	}
    
}
