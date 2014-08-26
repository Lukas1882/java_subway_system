
public class Link implements Cloneable{
	private Node from;
	private Node to;
	private int linkID;
	private String train;
	private int[] timeTable;
	private int spend;
	
	public Link(int ID, Node from, Node to,String train,int t1,int t2,int t3,int t4,int t5,int t6,int t7,int t8,int t9,int t10,int t11,int t12,int spend ){
	
		linkID=ID;		
		//train=name;
		this.from=from;
		this.to=to;
		this.train=train;
		int [] timeList={t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12};
		timeTable=timeList;
		this.spend=spend;
	}
	public int getSpend() {
		return spend;
	}
	public void setSpend(int spend) {
		this.spend = spend;
	}
	public Node getFrom() {
		return from;
	}
	public void setFrom(Node from) {
		this.from = from;
	}
	public Node getTo() {
		return to;
	}
	public void setTo(Node to) {
		this.to = to;
	}
	public int getLinkID() {
		return linkID;
	}
	public void setLinkID(int linkID) {
		this.linkID = linkID;
	}
	public String getTrain() {
		return train;
	}
	public void setTrain(String train) {
		this.train = train;
	}
	public int[] getTimeTable() {
		return timeTable;
	}
	public void setTimeTable(int[] timeList) {
		
		this.timeTable =timeList;
	}
	
	public Link clone() throws CloneNotSupportedException{
		Link cloned=(Link)super.clone();
		cloned.from=from;
		cloned.linkID=linkID;
		cloned.timeTable=timeTable;
		cloned.train=train;
		cloned.to=to;
		return cloned;
	}

}
