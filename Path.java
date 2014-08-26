import java.util.ArrayList;




public class Path implements Cloneable{
	private ArrayList<String>path;
	public Path(){
		path=new ArrayList<>();
	}
	public void add(String link){
		path.add(link);		
	}
	public Path clone() throws CloneNotSupportedException{
	    Path cloned=(Path)super.clone();
	    ArrayList<String>tempPath=new ArrayList<>();
	    for (int i=0;i<path.size();i++){
	    	tempPath.add(path.get(i));
	    }
	    cloned.path=tempPath;	    
		return cloned;
	}
	public ArrayList<String> getPath() {
		return path;
	}
	public void setPath(ArrayList<String> path) {
		this.path = path;
	}
	
	public Path addPath(Path one){
		Path two=new  Path();
		two.setPath(one.getPath());
		return two;
	}

}
