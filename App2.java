import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.*;
import java.util.LinkedList;

public class App2 extends JFrame{
    private static App2 app;
    public static App2 getApp(){
        if (app == null) {
            synchronized(App2.class){
                if (app == null) {
                    app = new App2();
                }
            }
        }
        return app;
    }
    private TreeFolder treeFolder = new TreeFolder();
    private JTree jTree;
    static private LinkedList<String> list = new LinkedList<>();
    
    private App2(){
        setLayout(new BorderLayout());

        

        JPanel p1 = new JPanel();
        Folders fold = new Folders("");
        jTree = treeFolder.setFolders(fold);

        FileChooser fileChoser = new FileChooser();
        fileChoser.getBtn().addActionListener(e -> {
            remove(jTree);
            createTree(fileChoser);
        });

        
        

        

        add(jTree,BorderLayout.WEST);
        add(fileChoser,BorderLayout.SOUTH);
        
        setSize(600,500);
        setVisible(true);
    }
    public void createTree(FileChooser p2){
        Folders folder = p2.setSelction();
            if (folder != null) {
                remove(jTree);
                jTree = treeFolder.setFolders(folder);
                jTree.addTreeSelectionListener(e -> {
                    try {
                        treeAction(jTree);
                    } catch (Exception ex) {
                        // TODO: handle exception
                    }
                });
                add(jTree,BorderLayout.WEST);
                setVisible(true);
            }
    }
    public void treeAction(JTree jt){
        TreePath[] paths = jt.getSelectionPaths();
        for (TreePath path : paths != null ? paths : new TreePath[0]) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
                Folders fd = (Folders)node.getUserObject();
                list.clear();
                setDataforFile(fd,1);
                TextGraphic tl = new TextGraphic(list);
                //System.out.println("helllo");
                add(tl,BorderLayout.CENTER);
                setVisible(true);

        }
    }
    private static void setDataforFile(Folders fd,int depth){
        if (list.isEmpty()) {
            list.add("*"+fd.name+" ( "+fd.getFolderSize(fd, 0)+" )");
        }
        String dash = "_";
        for (int i = 0; i < depth; i++) {
            dash+=dash;
        }
        for(Folder e:fd.getFolders()){
            if (e instanceof Folders) {
                list.add(dash+"-"+e.name);
                setDataforFile((Folders)e,depth+1);
            }else {
                FileObject e0 = (FileObject) e;
                list.add(dash+"-/"+e.name+" ("+e0.getSize()+")");
            }
        }
    }
    
    public static void main(String[] args) {
        new App2();
    }
}
class TextGraphic extends JPanel {
    private LinkedList<String> list;
    public TextGraphic(LinkedList<String> list){
        this.list=list;
        setBackground(Color.lightGray);
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        drawInfo(g2);
     }
     public void drawInfo(Graphics g){
        int yaxis = 25;
        Graphics2D g2 = (Graphics2D)g;
        for(String s:list){
            g2.drawString(s, 100, yaxis);
            yaxis+=15;
        }
     }
  }