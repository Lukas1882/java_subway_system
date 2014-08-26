
  
import java.awt.Dimension;  
import java.awt.Graphics;  
import java.net.URL;  
  
import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
  

public class PanelImage extends JPanel {  
  
    private static final long serialVersionUID = -7844180055896970944L;  
    private ImageIcon img; //±³¾°Í¼Æ¬  
      
    public PanelImage() {  
        this.img = new ImageIcon(getRes("1.jpg"));  
    }  
      
    public PanelImage(ImageIcon imgbg) {  
        if(imgbg !=null){             
            this.img = imgbg;  
        }else{  
            this.img = new ImageIcon(getRes("1.jpg"));  
        }  
    }  
  
    private URL getRes(String str){  
         return this.getClass().getClassLoader().getResource(str);  
    }  

    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        setOpaque(true);  
        Dimension d = getSize();  
        for (int x = 0; x < d.width; x += img.getIconWidth()){  
            for (int y = 0; y < d.height; y += img.getIconHeight()){  
                g.drawImage(img.getImage(), x, y, null, null);  
            }  
        }  
    }  
      

    public static void main(String[] args) {  
        JFrame jf = new JFrame("ÓÐ±³¾°µÄpanel");  
        jf.setSize(680, 670);  
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
        jf.add(new PanelImage());  
        jf.setVisible(true);  
    }  
}  