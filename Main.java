import java.util.ArrayList;


public class Main {
	
	private static WindowSubway  myWin;
		public static void main(String args[]){
			myWin=new WindowSubway();
			Thread t = new Thread(myWin);
		    t.start();	    
		}
}


