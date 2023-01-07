import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.*;


public class FileChooser extends JPanel{
  private JButton btn;
  private JFileChooser chooser;
  private String choosertitle;

  public FileChooser() {
    btn = new JButton("Select File");
    //btn.addActionListener(this);
    add(btn);
   }

  

  
  public JButton getBtn(){return btn;}

  
    public static void createFolder(File[] files,Folders folders) {
      for (File file : files) {
          if (file.isDirectory()) {
              Folders fd0 = new Folders(file.getName());
              folders.add(fd0);
              createFolder(file.listFiles(),fd0); 
          } else {
            FileObject fl = new FileObject(file.getName());
              fl.setFileSize(String.valueOf(fl.getFileKiloByte(file.getPath())));
              folders.add(fl);
          }
      }
  }
  public Folders setSelction(){
    chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);
       
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
        File fl = new File(String.valueOf(chooser.getSelectedFile()));
        Folders floders = new Folders(fl.getName());
        createFolder(fl.listFiles(),floders);
        return floders;
      }
    else {
      System.out.println("No Selection ");
      return null;
      }
  }
}