import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class test{
  public static void main(String[] args) {
    JFrame jf = new JFrame("Demo");
    Container cp = new Container();
    MyCanvas tl = new MyCanvas();
    cp.add(tl);
    jf.add(cp);
    jf.setSize(300, 200);
    jf.setVisible(true);
  }
}

class MyCanvas extends JComponent {

  @Override
  public void paint(Graphics g) {
      if(g instanceof Graphics2D)
      {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawString("This is gona be awesome",70,20); 
       }
   }
}