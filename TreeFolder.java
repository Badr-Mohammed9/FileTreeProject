import javax.swing.*;  
import javax.swing.tree.DefaultMutableTreeNode;  
public class TreeFolder extends JPanel {  
    TreeFolder(){  
        setSize(300,400);
    }  
    
    public JTree setFolders(Folder fd){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(fd);
        root = travFolders(root);
        JTree jt = new JTree(root);
        return jt;

    }
    private DefaultMutableTreeNode travFolders(DefaultMutableTreeNode root){
        if ((Folder)root.getUserObject() instanceof FileObject) {
            return root;
        }
        Folders f = (Folders)root.getUserObject();
        for(Folder e : f.getFolders()){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(e);
            root.add(node);
            node = travFolders(node);
        }
        return root;
    }
    
}  