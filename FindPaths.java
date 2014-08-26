import java.util.ArrayList;
public class FindPaths {
	private Node node1;
	private Node node2;
	private Node node3;
	private Node node4;
	private Node node5;
	private Node node6;
	private Node node7;
	private Node node8;
	private Node node9;
	private Node node10;
	private Node node11;
	private Node node12;
	private Node node13;
	private Node node14;
	private Node node15;
	private Node node16;
	private Node node17;
	private Node node18;
	private Node node19;
	private Node node20;
	private Node node21;
	private Node node22;
	private Node node23;
	private Node node24;
	private Node node25;
	private Node node26;
	private Node node27;
	private Node node28;
	private Node node29;
	private Node node30;
	private Node node31;
	private Node node32;
	private Node node33;
	private Node node34;
	private Node node35;
	private Node node36;
	private Node node37;
	private Node node38;
	ArrayList<NodeWeight>myList;
	private int size=1000,weight=1000000;
	private ArrayList<Path>pathList;
	private ArrayList<Link>linkList;
	private ArrayList<Link>rootLink;
	private ArrayList<Node>nodeList;
	private ArrayList<Path>shortestPath;	
	private ArrayList<Path>leastTimePath;
	private StringBuilder words;
	private ArrayList<Node> used;
	//private ArrayList<PathStep> steps; 
	private ArrayList<NodeWeight> weights; 
	private Path newWayPath;
	Node fromNode;
	public FindPaths(int from,int to,int myTime){			
		pathList=new ArrayList<>();
		newWayPath=new Path();
		linkList=new ArrayList<>();
		shortestPath=new ArrayList<>();
		leastTimePath=new ArrayList<>();
		nodeList=new ArrayList<>();
		words=new StringBuilder();
		used=new ArrayList<>();	
		rootLink=new ArrayList<>();	
		//steps=new ArrayList<>();
		weights=new ArrayList<>();	
		
		setting();		
	    fromNode=getNode(from);
        findPath(getNode(from),getNode(to));

		System.out.println(pathList.size() + " paths have been found!") ;
		words.append("\n**********************************\n"+pathList.size() + " paths have been found!\n**********************************\n");
		shortestPath();	
		leastTimePath(myTime);	
		//System.out.println(waitTime(0,getLink(34)));
		newway(getNode(from),getNode(to),myTime);
	}
	public void trainOrder(Path path){
		String myTrain="";
		for (int i=0;i<path.getPath().size();i++){
			if (myTrain.equals("")){
				System.out.println("Take "+getLink(Integer.valueOf(path.getPath().get(i))).getTrain()+" Line a"
					+ "t Station "+getLink(Integer.valueOf(path.getPath().get(i))).getFrom().getNodeID());
				myTrain=getLink(Integer.valueOf(path.getPath().get(i))).getTrain();
				words.append("Take "+getLink(Integer.valueOf(path.getPath().get(i))).getTrain()+" Line a"
					+ "t Station "+getLink(Integer.valueOf(path.getPath().get(i))).getFrom().getNodeID()+"\n");
			} else if (!myTrain.equals(getLink(Integer.valueOf(path.getPath().get(i))).getTrain())){
				System.out.println("Change the train at Station "+getLink(Integer.valueOf(path.getPath().get(i))).getFrom().getNodeID()
						+" to "+getLink(Integer.valueOf(path.getPath().get(i))).getTrain()+" Line.");
				myTrain=getLink(Integer.valueOf(path.getPath().get(i))).getTrain();
				words.append("Change the train at Station "+getLink(Integer.valueOf(path.getPath().get(i))).getFrom().getNodeID()
						+" to "+getLink(Integer.valueOf(path.getPath().get(i))).getTrain()+" Line.\n");
			} 
			if (i==path.getPath().size()-1){
				words.append("Get out at Station "+getLink(Integer.valueOf(path.getPath().get(i))).getTo().getNodeID()+"\n");
				System.out.println("Get out at Station "+getLink(Integer.valueOf(path.getPath().get(i))).getTo().getNodeID()+"\n");
			}			
		}
	}
	public Node getNode(int id){
		return nodeList.get(id-1);
	}
	public Link getLink(int id){
		return linkList.get(id-1);
	}
	public void shortestPath(){
		Path result;
        words.append("\nThe shortest path in node-count:\n----------------------------------\n");
		for (int i=0;i<pathList.size();i++){			
			result=pathList.get(i);
			if (result.getPath().size()<size){
				try {shortestPath.clear();}
				catch (java.lang.NullPointerException e){}
				
				size=result.getPath().size();
				shortestPath.add(result);
			} else if ((result.getPath().size()==size)){
				shortestPath.add(pathList.get(i));
			} else {
			}				
		}
		System.out.println("the least nobes path:");
		words.append(shortestPath.get(0).getPath().size()+" nodes are needed.\n----------------------------------\n");
		for (int i=0;i<shortestPath.size();i++){
			System.out.println("Path "+(i+1)+":");
			words.append("Path "+(i+1)+":\n");
			for (int j=0;j<shortestPath.get(i).getPath().size();j++){
				System.out.print(" "+shortestPath.get(i).getPath().get(j));
			}
			trainOrder(shortestPath.get(i));
		}
	}	
	public void leastTimePath(int nowTime){
		words.append("\n\nFind the least time-spent path:\n----------------------------------\n");
		Path result;
		int nextTime;
		int time=0;
		int least=100000;
		
for (int i=0;i<pathList.size();i++){
	time=nowTime;
	for (int j=0;j<pathList.get(i).getPath().size();j++){
	        
			time=nearTimeLink(time,getLink(Integer.valueOf(pathList.get(i).getPath().get(j))));
			time=addTime(time,getLink(Integer.valueOf(pathList.get(i).getPath().get(j))).getSpend());
	        }
	
			 if(time<least){
		    	leastTimePath.clear();
		    	leastTimePath.add(pathList.get(i));
		    	least=time;
		    } else if (time==least){
		    	leastTimePath.add(pathList.get(i));
		    } else{}
		}
    words.append(least/100+" hours and "+toMin(least)+" minutes are needed.\n----------------------------------\n");
    System.out.println("The shortest used-time is "+deleteTime(least,nowTime));
    for (int i=0;i<leastTimePath.size();i++){
    	System.out.println("Path "+(i+1));
    	words.append("Path"+(i+1)+"\n");
    	trainOrder(leastTimePath.get(i));
    }



	}
	public void setting(){

		node1=new Node(1);
		node2=new Node(2);
		node3=new Node(3);
		node4=new Node(4);
		node5=new Node(5);
		node6=new Node(6);
		node7=new Node(7);
		node8=new Node(8);
		node9=new Node(9);
		node10=new Node(10);
		node11=new Node(11);
		node12=new Node(12);
		node13=new Node(13);
		node14=new Node(14);
		node15=new Node(15);
		node16=new Node(16);
		node17=new Node(17);
		node18=new Node(18);
		node19=new Node(19);
		node20=new Node(20);
		node21=new Node(21);
		node22=new Node(22);
		node23=new Node(23);
		node24=new Node(24);
		node25=new Node(25);
		node26=new Node(26);
		node27=new Node(27);
		node28=new Node(28);
		node29=new Node(29);
		node30=new Node(30);
		node31=new Node(31);
		node32=new Node(32);
		node33=new Node(33);
		node34=new Node(34);
		node35=new Node(35);
		node36=new Node(36);
		node37=new Node(37);
		node38=new Node(38);
		nodeList.add(node1);
		nodeList.add(node2);
		nodeList.add(node3);
		nodeList.add(node4);		
		nodeList.add(node5);
		nodeList.add(node6);
		nodeList.add(node7);
		nodeList.add(node8);
		nodeList.add(node9);
		nodeList.add(node10);
		nodeList.add(node11);
		nodeList.add(node12);
		nodeList.add(node13);
		nodeList.add(node14);
		nodeList.add(node15);
		nodeList.add(node16);
		nodeList.add(node17);
		nodeList.add(node18);	
		nodeList.add(node19);
		nodeList.add(node20);
		nodeList.add(node21);
		nodeList.add(node22);
		nodeList.add(node23);		
		nodeList.add(node24);
		nodeList.add(node25);
		nodeList.add(node26);		
		nodeList.add(node27);		
		nodeList.add(node28);		
		nodeList.add(node29);
		nodeList.add(node30);
		nodeList.add(node31);
		nodeList.add(node32);
		nodeList.add(node33);
		nodeList.add(node34);
		nodeList.add(node35);
		nodeList.add(node36);
		nodeList.add(node37);
		nodeList.add(node38);

		//ddd={2,3};
		///////  A line links //////
		Link link1=new Link(1,node1,node4,"A",0,30,100,200,340,400,515,620,700,820,915,1025,30);
		Link link2=new Link(2,node4,node1,"A",310,340,410,510,700,710,825,930,1010,1130,1225,1335,30);
		Link link3=new Link(3,node4,node5,"A",30,100,130,230,420,430,545,650,730,850,945,1055,30);
		Link link4=new Link(4,node5,node4,"A",250,320,350,450,640,650,805,910,950,1110,1205,1315,2);
		Link link5=new Link(5,node5,node6,"A",100,130,200,300,450,500,615,720,800,920,1015,1125,20);
		Link link6=new Link(6,node6,node5,"A",230,300,330,430,620,630,745,850,930,1050,1145,1255,20);
		Link link7=new Link(7,node6,node8,"A",120,150,220,320,510,520,635,740,820,940,1035,1145,40);
		Link link8=new Link(8,node8,node6,"A",200,230,300,400,550,600,715,820,900,1020,1115,1225,30);
		Link link9=new Link(9,node8,node9,"A",200,230,300,400,550,600,715,820,900,1020,1115,1225,30);
		Link link10=new Link(10,node8,node9,"A",120,150,220,320,510,520,635,740,820,940,1035,1145,40);
		Link link11=new Link(11,node9,node15,"A",230,300,330,430,620,630,745,850,930,1050,1145,1255,20);
		Link link12=new Link(12,node15,node9,"A",100,130,200,300,450,500,615,720,800,920,1015,1125,20);
		Link link13=new Link(13,node15,node17,"A",250,320,350,450,640,650,805,910,950,1110,1205,1315,20);
		Link link14=new Link(14,node17,node15,"A",30,100,130,230,420,430,545,650,730,850,945,1055,30);
		Link link15=new Link(15,node17,node28,"A",310,340,410,510,700,710,825,930,1010,1130,1225,1335,30);
		Link link16=new Link(16,node28,node17,"A",0,30,100,200,340,400,515,620,700,820,915,1025,30);
		
		////// Line C /////
		Link link17=new Link(17,node1,node2,"C",20,120,200,230,310,330,400,420,450,530,600,620,20);
		Link link18=new Link(18,node2,node1,"C",320,420,500,530,610,630,700,720,750,830,900,920,30);
		Link link19=new Link(19,node2,node3,"C",40,140,220,250,330,350,420,440,510,550,620,640,30);
		Link link20=new Link(20,node3,node2,"C",240,340,420,450,530,550,620,640,710,750,820,840,20);
		Link link21=new Link(21,node3,node7,"C",110,210,250,320,400,420,450,510,540,620,650,710,40);
		Link link22=new Link(22,node7,node3,"C",240,340,420,450,530,550,620,640,710,750,820,840,20);
		Link link23=new Link(23,node7,node18,"C",150,250,330,400,440,500,530,550,620,700,730,750,20);
		Link link24=new Link(24,node18,node7,"C",210,310,350,420,500,520,550,610,640,720,750,810,30);
		Link link25=new Link(25,node18,node16,"C",210,310,350,420,500,520,550,610,640,720,750,810,30);
		Link link26=new Link(26,node16,node18,"C",150,250,330,400,440,500,530,550,620,700,730,750,20);
		Link link27=new Link(27,node16,node15,"C",240,340,420,450,530,550,620,640,710,750,820,840,20);
		Link link28=new Link(28,node15,node16,"C",110,210,250,320,400,420,450,510,540,620,650,710,40);
		Link link29=new Link(29,node15,node17,"C",300,400,440,510,550,610,640,700,730,810,840,900,20);
		Link link30=new Link(30,node17,node15,"C",40,140,220,250,330,350,420,440,510,550,620,640,30);
		Link link31=new Link(31,node17,node28,"C",320,420,500,530,610,630,700,720,750,830,900,920,30);
		Link link32=new Link(32,node28,node17,"C",20,120,200,230,310,330,400,420,450,530,600,620,20);
		
		
		/////// Line B  ///////
		Link link33=new Link(33,node1,node2,"B",100,130,300,330,400,500,530,600,630,700,730,800,30);
		Link link34=new Link(34,node2,node1,"B",300,330,500,530,600,700,730,800,830,900,930,1000,30);
		Link link35=new Link(35,node2,node13,"B",130,200,330,400,430,530,600,630,700,730,800,830,30);
		Link link36=new Link(36,node13,node2,"B",230,300,430,500,530,630,700,730,800,830,900,930,30);
		Link link37=new Link(37,node13,node14,"B",200,230,400,430,500,600,630,700,730,800,830,900,30);
		Link link38=new Link(38,node14,node13,"B",200,230,400,430,500,600,630,700,730,800,830,900,30);
		Link link39=new Link(39,node14,node11,"B",230,300,430,500,530,630,700,730,800,830,900,930,30);
		Link link40=new Link(40,node11,node14,"B",130,200,330,400,430,530,600,630,700,730,800,830,30);
		Link link41=new Link(41,node11,node12,"B",300,330,500,530,600,700,730,800,830,900,930,1000,30);
		Link link42=new Link(42,node12,node11,"B",100,130,300,330,400,500,530,600,630,700,730,800,30);
		
		////// Line D ////
		Link link43=new Link(43,node30,node36,"D",100,140,240,300,330,400,430,500,520,600,630,730,20);
		Link link44=new Link(44,node36,node30,"D",400,440,540,600,630,700,730,800,820,900,930,1030,20);
		Link link45=new Link(45,node36,node11,"D",120,200,300,320,350,420,450,520,540,620,650,750,20);
		Link link46=new Link(46,node11,node36,"D",340,420,520,540,610,640,710,740,800,840,910,1010,20);
		Link link47=new Link(47,node11,node33,"D",140,220,320,340,410,440,510,540,600,640,710,810,20);
		Link link48=new Link(48,node33,node11,"D",320,400,500,520,550,620,650,720,740,820,850,950,20);
		Link link49=new Link(49,node33,node34,"D",200,240,340,400,430,500,530,600,620,700,730,830,20);
		Link link50=new Link(50,node34,node33,"D",300,340,440,500,530,600,630,700,720,800,830,930,20);
		Link link51=new Link(51,node34,node35,"D",220,300,400,420,450,520,550,620,640,720,750,850,20);
		Link link52=new Link(52,node35,node34,"D",240,320,420,440,510,540,610,640,700,740,810,910,20);
		Link link53=new Link(53,node35,node37,"D",240,320,420,440,510,540,610,640,700,740,810,910,20);
		Link link54=new Link(54,node37,node35,"D",220,300,400,420,450,520,550,620,640,720,750,850,20);
		Link link55=new Link(55,node37,node17,"D",300,340,440,500,530,600,630,700,720,800,830,930,20);
		Link link56=new Link(56,node17,node37,"D",200,240,340,400,430,500,530,600,620,700,730,830,20);
		Link link57=new Link(57,node17,node31,"D",320,400,500,520,550,620,650,720,740,820,850,950,20);
		Link link58=new Link(58,node31,node17,"D",140,220,320,340,410,440,510,540,600,640,710,810,20);
		Link link59=new Link(59,node31,node38,"D",340,420,520,540,610,640,710,740,800,840,910,1010,20);
		Link link60=new Link(60,node38,node31,"D",120,200,300,320,350,420,450,520,540,620,650,750,20);
		Link link61=new Link(61,node38,node23,"D",400,440,540,600,630,700,730,800,820,900,930,1030,20);
		Link link62=new Link(62,node23,node38,"D",100,140,240,300,330,400,430,500,520,600,630,730,20);
		
		///// Line E
		Link link63=new Link(63,node12,node11,"E",20,120,200,230,310,330,400,420,450,530,600,620,20);
		Link link64=new Link(64,node11,node12,"E",320,420,500,530,610,630,700,720,750,830,900,920,30);
		Link link65=new Link(65,node11,node27,"E",40,140,220,250,330,350,420,440,510,550,620,640,30);
		Link link66=new Link(66,node27,node11,"E",300,400,440,510,550,610,640,700,730,810,840,900,20);
		Link link67=new Link(67,node27,node26,"E",110,210,250,320,400,420,450,510,540,620,650,710,40);
		Link link68=new Link(68,node26,node27,"E",240,340,420,450,530,550,620,640,710,750,820,840,20);
		Link link69=new Link(69,node26,node25,"E",150,250,330,400,440,500,530,550,620,700,730,750,20);
		Link link70=new Link(70,node25,node26,"E",210,310,350,420,500,520,550,610,640,720,750,810,30);
		Link link71=new Link(71,node25,node24,"E",210,310,350,420,500,520,550,610,640,720,750,810,30);
		Link link72=new Link(72,node24,node25,"E",150,250,330,400,440,500,530,550,620,700,730,750,20);
		Link link73=new Link(73,node24,node15,"E",240,340,420,450,530,550,620,640,710,750,820,840,20);
		Link link74=new Link(74,node15,node24,"E",110,210,250,320,400,420,450,510,540,620,650,710,40);		
		Link link75=new Link(75,node15,node21,"E",300,400,440,510,550,610,640,700,730,810,840,900,20);
		Link link76=new Link(76,node21,node15,"E",40,140,220,250,330,350,420,440,510,550,620,640,30);
		Link link77=new Link(77,node21,node23,"E",320,420,500,530,610,630,700,720,750,830,900,920,30);
		Link link78=new Link(78,node23,node21,"E",20,120,200,230,310,330,400,420,450,530,600,620,20);
		
		/////// Line F 
		Link link79=new Link(79,node23,node19,"F",10,40,110,140,210,240,310,340,505,535,605,705,30);
		Link link80=new Link(80,node19,node23,"F",320,350,420,450,520,550,720,750,815,845,915,1015,20);
		Link link81=new Link(81,node19,node22,"F",40,110,140,210,240,310,340,510,535,605,635,735,30);
		Link link82=new Link(82,node22,node19,"F",300,330,400,430,500,530,700,730,755,825,895,955,20);
		Link link83=new Link(83,node8,node22,"F",240,310,340,410,440,510,640,710,735,805,835,935,20);
		
		Link link84=new Link(84,node22,node8,"F",110,140,210,240,310,340,510,540,605,635,705,805,30);
		 
		Link link85=new Link(85,node18,node8,"F",210,240,310,340,410,440,610,640,705,735,805,905,30);
		Link link86=new Link(86,node8,node18,"F",140,210,240,310,340,410,540,610,635,705,735,835,30);
		Link link87=new Link(87,node10,node18,"F",140,210,240,310,340,410,540,610,635,705,735,835,30);
		Link link88=new Link(88,node18,node10,"F",210,240,310,340,410,440,610,640,705,735,805,905,30);
		Link link89=new Link(89,node20,node10,"F",110,140,210,240,310,340,510,540,605,635,705,805,30);
		Link link90=new Link(90,node10,node20,"F",240,310,340,410,440,510,640,710,735,805,835,935,20);
		Link link91=new Link(91,node11,node20,"F",40,110,140,210,240,310,340,510,535,605,635,735,30);
		Link link92=new Link(92,node20,node11,"F",300,330,400,430,500,530,700,730,755,825,895,955,20);
		Link link93=new Link(93,node12,node11,"F",10,40,110,140,210,240,310,340,505,535,605,705,30);
		Link link94=new Link(94,node11,node12,"F",320,350,420,450,520,550,720,750,815,845,915,1015,20);
		
		//// Line G
		Link link95=new Link(95,node30,node29,"G",25,125,225,325,400,430,440,500,530,630,700,800,5);
		Link link96=new Link(96,node29,node30,"G",200,300,400,500,535,605,615,635,705,805,835,935,5);
		Link link97=new Link(97,node29,node13,"G",30,130,230,330,405,435,445,505,535,635,705,805,15);
		Link link98=new Link(98,node13,node29,"G",155,255,355,455,530,600,610,630,700,800,830,930,5);		
		Link link99=new Link(99,node13,node3,"G",45,145,245,345,420,450,500,520,550,650,720,820,20);
		Link link100=new Link(100,node3,node13,"G",150,250,350,450,525,555,605,625,655,755,825,925,5);
		Link link101=new Link(101,node3,node6,"G",105,205,305,405,440,510,520,540,610,710,740,840,20);
		Link link102=new Link(102,node6,node3,"G",145,245,345,445,520,550,600,620,650,750,820,920,5);
		Link link103=new Link(103,node6,node32,"G",125,225,325,425,500,530,540,600,630,730,800,900,20);
		Link link104=new Link(104,node32,node6,"G",125,225,325,425,500,530,540,600,630,730,800,900,20);
		Link link105=new Link(105,node32,node22,"G",145,245,345,445,520,550,600,620,650,750,820,920,5);
		Link link106=new Link(106,node22,node32,"G",105,205,305,405,440,510,520,540,610,710,740,840,20);
		Link link107=new Link(107,node22,node21,"G",150,250,350,450,525,555,605,625,655,755,825,925,5);
		Link link108=new Link(108,node21,node22,"G",45,145,245,345,420,450,500,520,550,650,720,820,20);
		Link link109=new Link(109,node21,node31,"G",155,255,355,455,530,600,610,630,700,800,830,930,5);
		Link link110=new Link(110,node31,node21,"G",30,130,230,330,405,435,445,505,535,635,705,805,15);
		Link link111=new Link(111,node31,node28,"G",200,300,400,500,535,605,615,635,705,805,835,935,5);
		Link link112=new Link(112,node28,node31,"G",25,125,225,325,400,430,440,500,530,630,700,800,5);
	
		
		
		node1.addIntoLink(link34);
		node1.addIntoLink(link18);
		node1.addIntoLink(link2);
		node1.addOutList(link33);
		node1.addOutList(link17);
		node1.addOutList(link1);
		
		node2.addIntoLink(link36);
		node2.addIntoLink(link20);
		node2.addIntoLink(link17);
		node2.addIntoLink(link33);
		node2.addOutList(link35);
		node2.addOutList(link19);
		node2.addOutList(link18);
		node2.addOutList(link34);
		
		node3.addIntoLink(link22);
		node3.addIntoLink(link102);
		node3.addIntoLink(link19);
		node3.addIntoLink(link99);
		node3.addOutList(link21);
		node3.addOutList(link101);
		node3.addOutList(link100);
		node3.addOutList(link20);
		
		
		node4.addIntoLink(link1);
		node4.addIntoLink(link4);
		node4.addOutList(link2);
		node4.addOutList(link3);
		
		node5.addIntoLink(link3);
		node5.addIntoLink(link6);
		node5.addOutList(link5);
		node5.addOutList(link4);
		
		node6.addIntoLink(link101);
		node6.addIntoLink(link5);
		node6.addIntoLink(link104);
		node6.addIntoLink(link8);
		node6.addOutList(link7);
		node6.addOutList(link103);
		node6.addOutList(link6);
		node6.addOutList(link102);
		
		node7.addIntoLink(link21);
		node7.addIntoLink(link24);
		node7.addOutList(link23);	
		node7.addOutList(link22);	
		
		node8.addIntoLink(link10);
		node8.addIntoLink(link84);
		node8.addIntoLink(link7);
		node8.addIntoLink(link85);
		node8.addOutList(link86);
		node8.addOutList(link9);
		node8.addOutList(link83);
		node8.addOutList(link8);
		
		node9.addIntoLink(link12);
		node9.addIntoLink(link9);
		node9.addOutList(link11);	
		node9.addOutList(link10);	
		
		node10.addIntoLink(link89);
		node10.addIntoLink(link88);
		node10.addOutList(link90);	
		node10.addOutList(link87);	
		
		node11.addIntoLink(link63);
		node11.addIntoLink(link93);
		node11.addIntoLink(link42);
		node11.addIntoLink(link48);
		node11.addIntoLink(link66);
		node11.addIntoLink(link92);
		node11.addIntoLink(link39);
		node11.addIntoLink(link45);
		node11.addOutList(link46);
		node11.addOutList(link40);
		node11.addOutList(link91);
		node11.addOutList(link65);
		node11.addOutList(link47);
		node11.addOutList(link41);
		node11.addOutList(link94);
		node11.addOutList(link64);
		
		node12.addIntoLink(link41);
		node12.addIntoLink(link94);
		node12.addIntoLink(link64);
		node12.addOutList(link42);	
		node12.addOutList(link93);	
		node12.addOutList(link63);
		
		node13.addIntoLink(link38);
		node13.addIntoLink(link100);
		node13.addIntoLink(link35);
		node13.addIntoLink(link97);
		node13.addOutList(link98);
		node13.addOutList(link37);
		node13.addOutList(link36);
		node13.addOutList(link99);
		
		node14.addIntoLink(link40);
		node14.addIntoLink(link37);
		node14.addOutList(link39);	
		node14.addOutList(link38);
		
		node15.addIntoLink(link30);
		node15.addIntoLink(link14);
		node15.addIntoLink(link76);
		node15.addIntoLink(link11);
		node15.addIntoLink(link27);
		node15.addIntoLink(link73);
		node15.addOutList(link29);
		node15.addOutList(link13);
		node15.addOutList(link75);
		node15.addOutList(link12);
		node15.addOutList(link28);
		node15.addOutList(link74);
		
		node16.addIntoLink(link25);
		node16.addIntoLink(link28);
		node16.addOutList(link27);	
		node16.addOutList(link26);
		
		node17.addIntoLink(link35);
		node17.addIntoLink(link32);
		node17.addIntoLink(link16);
		node17.addIntoLink(link58);
		node17.addIntoLink(link13);
		node17.addIntoLink(link29);
		node17.addOutList(link31);
		node17.addOutList(link15);
		node17.addOutList(link57);
		node17.addOutList(link14);
		node17.addOutList(link30);
		node17.addOutList(link56);
		
		
		node18.addIntoLink(link26);
		node18.addIntoLink(link86);
		node18.addIntoLink(link23);
		node18.addIntoLink(link87);
		node18.addOutList(link88);
		node18.addOutList(link25);
		node18.addOutList(link85);
		node18.addOutList(link24);
		
		node19.addIntoLink(link79);
		node19.addIntoLink(link82);
		node19.addOutList(link81);	
		node19.addOutList(link80);
		
		node20.addIntoLink(link90);
		node20.addIntoLink(link91);
		node20.addOutList(link92);	
		node20.addOutList(link89);
		
		node21.addIntoLink(link75);
		node21.addIntoLink(link78);
		node21.addIntoLink(link110);
		node21.addIntoLink(link107);
		node21.addOutList(link77);	
		node21.addOutList(link108);
		node21.addOutList(link76);	
		node21.addOutList(link109);
		
		node22.addIntoLink(link83);
		node22.addIntoLink(link81);
		node22.addIntoLink(link108);
		node22.addIntoLink(link105);
		node22.addOutList(link82);	
		node22.addOutList(link107);
		node22.addOutList(link106);	
		node22.addOutList(link84);
		
		node23.addIntoLink(link61);
		node23.addIntoLink(link77);
		node23.addIntoLink(link80);
		node23.addOutList(link79);
		node23.addOutList(link78);	
		node23.addOutList(link62);
		
		node24.addIntoLink(link71);
		node24.addIntoLink(link74);
		node24.addOutList(link72);	
		node24.addOutList(link73);
		
		node25.addIntoLink(link72);
		node25.addIntoLink(link69);
		node25.addOutList(link70);	
		node25.addOutList(link71);
		
		node26.addIntoLink(link70);
		node26.addIntoLink(link67);
		node26.addOutList(link68);	
		node26.addOutList(link69);
		
		node27.addIntoLink(link68);
		node27.addIntoLink(link65);
		node27.addOutList(link66);	
		node27.addOutList(link67);
		
		node28.addIntoLink(link31);
		node28.addIntoLink(link15);
		node28.addIntoLink(link111);
		node28.addOutList(link112);	
		node28.addOutList(link16);
		node28.addOutList(link32);
		
		node29.addIntoLink(link98);
		node29.addIntoLink(link95);
		node29.addOutList(link96);	
		node29.addOutList(link97);
		
		node30.addIntoLink(link44);
		node30.addIntoLink(link96);
		node30.addOutList(link43);	
		node30.addOutList(link95);
		
		node31.addIntoLink(link57);
		node31.addIntoLink(link112);
		node31.addIntoLink(link60);
		node31.addIntoLink(link109);
		node31.addOutList(link110);	
		node31.addOutList(link59);
		node31.addOutList(link111);	
		node31.addOutList(link58);
		
		node32.addIntoLink(link106);
		node32.addIntoLink(link103);
		node32.addOutList(link105);	
		node32.addOutList(link104);
		
		node33.addIntoLink(link44);
		node33.addIntoLink(link96);
		node33.addOutList(link43);	
		node33.addOutList(link95);
		
		node34.addIntoLink(link99);
		node34.addIntoLink(link52);
		node34.addOutList(link50);	
		node34.addOutList(link51);
		
		node35.addIntoLink(link54);
		node35.addIntoLink(link51);
		node35.addOutList(link53);	
		node35.addOutList(link52);
		
		node36.addIntoLink(link43);
		node36.addIntoLink(link46);
		node36.addOutList(link45);	
		node36.addOutList(link44);
		
		node37.addIntoLink(link53);
		node37.addIntoLink(link56);
		node37.addOutList(link54);	
		node37.addOutList(link55);
		
		node38.addIntoLink(link59);
		node38.addIntoLink(link62);
		node38.addOutList(link61);	
		node38.addOutList(link60);
		
		linkList.add(link1);
		linkList.add(link2);
		linkList.add(link3);
		linkList.add(link4);
		linkList.add(link5);
		linkList.add(link6);
		linkList.add(link7);
		linkList.add(link8);
		linkList.add(link9);
		linkList.add(link10);
		linkList.add(link11);
		linkList.add(link12);
		linkList.add(link13);
		linkList.add(link14);
		linkList.add(link15);
		linkList.add(link16);
		linkList.add(link17);
		linkList.add(link18);
		linkList.add(link19);
		linkList.add(link20);
		linkList.add(link21);
		linkList.add(link22);
		linkList.add(link23);
		linkList.add(link24);
		linkList.add(link25);
		linkList.add(link26);
		linkList.add(link27);
		linkList.add(link28);
		linkList.add(link29);
		linkList.add(link30);
		linkList.add(link31);
		linkList.add(link32);
		linkList.add(link33);
		linkList.add(link34);
		linkList.add(link35);
		linkList.add(link36);
		linkList.add(link37);
		linkList.add(link38);
		linkList.add(link39);
		linkList.add(link40);
		linkList.add(link41);
		linkList.add(link42);
		linkList.add(link43);
		linkList.add(link44);
		linkList.add(link45);
		linkList.add(link46);
		linkList.add(link47);
		linkList.add(link48);
		linkList.add(link49);
		linkList.add(link50);
		linkList.add(link51);
		linkList.add(link52);
		linkList.add(link53);
		linkList.add(link54);
		linkList.add(link55);
		linkList.add(link56);
		linkList.add(link57);
		linkList.add(link58);
		linkList.add(link59);
		linkList.add(link60);
		linkList.add(link61);
		linkList.add(link62);
		linkList.add(link63);
		linkList.add(link64);
		linkList.add(link65);
		linkList.add(link66);
		linkList.add(link67);
		linkList.add(link68);
		linkList.add(link69);
		linkList.add(link70);
		linkList.add(link71);
		linkList.add(link72);
		linkList.add(link73);
		linkList.add(link74);
		linkList.add(link75);
		linkList.add(link76);
		linkList.add(link77);
		linkList.add(link78);
		linkList.add(link79);
		linkList.add(link80);
		linkList.add(link81);
		linkList.add(link82);
		linkList.add(link83);
		linkList.add(link84);
		linkList.add(link85);
		linkList.add(link86);
		linkList.add(link87);
		linkList.add(link88);
		linkList.add(link89);
		linkList.add(link90);
		linkList.add(link91);
		linkList.add(link92);
		linkList.add(link93);
		linkList.add(link94);
		linkList.add(link95);
		linkList.add(link96);
		linkList.add(link97);
		linkList.add(link98);
		linkList.add(link99);
		linkList.add(link100);
		linkList.add(link101);
		linkList.add(link102);
		linkList.add(link103);
		linkList.add(link104);
		linkList.add(link105);
		linkList.add(link106);	
		linkList.add(link107);
		linkList.add(link108);
		linkList.add(link109);
		linkList.add(link110);
		linkList.add(link111);
		linkList.add(link112);		
	}	
	 public  void search(Node here,Node aim, PassedNodes nodes, Path history){	   
	    	for (int i=0;i<here.getOutList().size();i++){
	    		if (nodes.getNodes().contains(here.getOutList().get(i).getTo().getNodeID()+"")){    			
	    		} else if (here.getOutList().get(i).getTo()==aim)
	    		{
	    			pathList.add(pathAddLink(history,here.getOutList().get(i)));
	    		} else {
	    			search(here.getOutList().get(i).getTo(),aim, updateNodes(nodes,here.getOutList().get(i).getTo()),pathAddLink(history,here.getOutList().get(i)));  			
	    			continue;
	    		}
	    	}       
	    }
	    
	    public  void findPath(Node one,Node two){
	    	Path myPath=new Path();
			PassedNodes nodes=new PassedNodes();
			nodes.add(one);
	    	search(one,two,nodes,myPath);
	    }
	    public  PassedNodes updateNodes(PassedNodes nodes,Node node){
	    	PassedNodes newNodes=new PassedNodes();
	    	
	    	try{newNodes=(PassedNodes)nodes.clone();
	    	}catch(Exception e){
	    		
	    	}   
	    	newNodes.add(node);
	    	return newNodes;
	    }
	    public  Path pathAddLink(Path path,Link link){
	    	Path newPath=new Path();
	    	try{newPath=(Path)path.clone();
	    	}catch(Exception e){  		
	    	}   	
	    	newPath.add(link.getLinkID()+"");
	    	return newPath;
	    }
	    public int toMin(int time){
	    	int  min=time-(time/100)*100;
	    	return min;
	    }
	    public int addTime(int t1,int t2){
	    	int t31=t1/100+t2/100;
	    	int t32= toMin(t1)+toMin(t2);
	    	if(t32>=60){
	    		t32=t32-60;
	    		t31=t31+1;
	    	}
	    	int t3=t31*100+t32;
	    	return t3;
	    }
	    public int deleteTime(int t1,int t2){
	    	int t31=t1/100-t2/100;
	    	int t32= toMin(t1)-toMin(t2);
	    	if(t32<0){
	    		t32=t32+60;
	    		t31=t31-1;
	    	}
	    	int t3=t31*100+t32;
	    	return t3;
	    }
	    public int nearTimeLink(int now,Link link){    	
	    	for (int i=0;i<link.getTimeTable().length;i++){
	    		if (now<=link.getTimeTable()[i]){
	    			return Integer.valueOf(link.getTimeTable()[i]);
	    		}
	    		else if(now>link.getTimeTable()[i]){
	    	} 
	    	}
	    	return 77777;  	
	    }
	    public int waitTime(int now,Link link){
	    	for (int i=0;i<link.getTimeTable().length;i++){
	    		if (now<=link.getTimeTable()[i]){
	    			return deleteTime(Integer.valueOf(link.getTimeTable()[i]),now);
	    		}
	    		else if(now>link.getTimeTable()[i]){
	    	} 
	    	}
	    	return 77777;  	
	    }
	    public StringBuilder getWords() {
			return words;
		}	
		
		public void newway(Node here,Node aim,int now){
			words.append("\n----------------------------------\nUsing the new Dijkstra:\n");
			NodeWeight begin=new NodeWeight(now,here,null);
			weights.add(begin);
			used.add(here);
			myList=new ArrayList<>();
			while(true){
				System.out.println("dd");
				Boolean getAim=false;
				weight=100000;
				for (int i=0;i<weights.size();i++){
					// 其中一个node的out links
					for (int j=0;j<weights.get(i).getNode().getOutList().size();j++){				
						if (used.contains(weights.get(i).getNode().getOutList().get(j).getTo())){}
						else {
							if (weight>addTime(waitTime(weights.get(i).getWeight(),weights.get(i).getNode().getOutList().get(j)), addTime(weights.get(i).getNode().getOutList().get(j).getSpend(),weights.get(i).getWeight()))){
								//System.out.println(weight+"  "+weights.get(i).getNode().getOutList().get(j).getSpend()+weights.get(i).getWeight());
								weight=addTime(waitTime(weights.get(i).getWeight(),weights.get(i).getNode().getOutList().get(j)), addTime(weights.get(i).getNode().getOutList().get(j).getSpend(),weights.get(i).getWeight()));
								myList.clear();
								//used.add(weights.get(i).getNode().getOutList().get(j).getTo());
								myList.add(new NodeWeight(weight,weights.get(i).getNode().getOutList().get(j).getTo(),weights.get(i).getNode().getOutList().get(j)));
							} else if(weight==addTime(waitTime(weight,weights.get(i).getNode().getOutList().get(j)), addTime(weights.get(i).getNode().getOutList().get(j).getSpend(),weights.get(i).getWeight()))){
								myList.add(new NodeWeight(weight,weights.get(i).getNode().getOutList().get(j).getTo(),weights.get(i).getNode().getOutList().get(j)));
								//used.add(weights.get(i).getNode().getOutList().get(j).getTo());
							}
						}
					}
				}
				used.add(myList.get(0).getNode());
				for (int i=0;i<myList.size();i++){
					weights.add(myList.get(i));
				}	
				for (int i=0;i<weights.size();i++){
					if(weights.get(i).getNode()==aim){
						words.append("----------------------------------\nNeed "+weights.get(i).getWeight()/100+" hours and "+(weights.get(i).getWeight()-weights.get(i).getWeight()/100*100)+" minutes.");
						words.append("\n----------------------------------\n");
						System.out.println();
						weights.get(i).getMyRoot();
						findRoot(aim);						
						trainOrder(newWayPath);
						getAim=true;
						break;
					}
				}			
				if(getAim)
					break;
			}			
		}
		public void findLinkInWeight(Node node){
			for (int i=0;i<weights.size();i++)
			{
				if (weights.get(i).getNode()==node){
					System.out.println(weights.get(i).getMyRoot().getLinkID()+"  dddssss");
					for (int j=0;j<weights.get(i).getRoot().size();j++){
						rootLink.add(weights.get(i).getMyRoot());
					}
					
				}
				
            
				
			}
			
		}
        public void findRoot(Node node){
        	//findLinkInWeight(node);
        	System.out.println(weights.size());
			findLinkInWeight(node);
			
		
			if (rootLink.get(rootLink.size()-1).getFrom()!=fromNode){
				findRoot(rootLink.get(rootLink.size()-1).getFrom());
			} else{
				for (int j=0;j<rootLink.size();j++){
					newWayPath.add(rootLink.get(rootLink.size()-j-1).getLinkID()+"");
					linkList.add(rootLink.get(rootLink.size()-j-1));
				}
			}
}

}
