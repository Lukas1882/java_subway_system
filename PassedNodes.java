import java.util.ArrayList;
public class PassedNodes implements Cloneable{
	private ArrayList<String>nodes;
	public PassedNodes(){
		nodes=new ArrayList<>();
	}
	public void add(Node newNode){
		nodes.add(newNode.getNodeID()+"");		
	}
	
	public PassedNodes clone()throws CloneNotSupportedException{
		PassedNodes cloned=(PassedNodes)super.clone();
		ArrayList<String>tempNodes=new ArrayList<>();
		    for (int i=0;i<nodes.size();i++){
		    	tempNodes.add(nodes.get(i));
		    }
		    cloned.nodes=tempNodes;	
		return cloned;
	}
	public ArrayList<String> getNodes() {
		return nodes;
	}
	public void setNodes(ArrayList<String> nodes) {
		this.nodes = nodes;
	}
	

}
