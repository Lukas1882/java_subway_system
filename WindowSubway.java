
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;






public class WindowSubway extends JFrame implements ActionListener, Runnable{
	private String myName;
	private JPanel chatPanel;
	private PrintWriter writer;
	private JPanel top,east;
	private PanelImage mid;
	private JLabel jlb1,jlb2,jlb3;
	private JTextField jt1,jt2,jt3,jt4;
	private TextArea ta;
	private JTextArea textArea;
	private JButton button;
	private Scanner scan;
	private Image img;
	
	public void run(){
		
		buildFrame();
		
	}

	public void buildFrame(){
		east=new JPanel();
		top=new JPanel();
		top.add(jlb1=new JLabel("orginal node"));
		top.add(jt1=new JTextField("Node ID",4));
		top.add(jlb2=new JLabel("terminal node"));
		top.add(jt2=new JTextField("Node ID",4));
		top.add(jlb3=new JLabel("Start Time: "));
		top.add(jt3=new JTextField("hour"));
		top.add(jt4=new JTextField("minute"));
		top.setLayout(new FlowLayout());
		top.add(button=new JButton("Search"));
		button.addActionListener(this);
	    mid=new PanelImage();
	    ta=new TextArea("", 40, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
	    ta.setEditable(false);
	    east.add(ta);
	  
     	this.setLayout(new BorderLayout());                              /** Adds to the frame and the frame setting*/  
        this.add(top,BorderLayout.NORTH);
        this.add(east,BorderLayout.EAST);
        this.add(mid,BorderLayout.CENTER);
		this.setTitle("Subway Path-found System");   
	    this.setSize(920,695);
	    this.setLocation(0,0);
	    this.setVisible(true);
	    this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
         }
	
	public void actionPerformed(ActionEvent e) {
		FindPaths finding=new FindPaths(Integer.valueOf(jt1.getText()),Integer.valueOf(jt2.getText()),Integer.valueOf(jt3.getText())*100+Integer.valueOf(jt4.getText()));
		
		ta.append(finding.getWords().toString());
	
	}
	

}


