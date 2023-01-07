import java.util.ArrayList;

public class Folders extends Folder {
    public Folders(String name) {
        super(name);
    }
    private ArrayList<Folder> folders = new ArrayList<>();

    @Override
    public void add(Folder fd) {
        folders.add(fd);
        
    }

    @Override
    public void remove(Folder fd) {
        folders.remove(fd);
        
    }

    @Override
    public void display(int depth) {
        String dep = "-";
        for (int i = 0; i < depth; i++) {
            dep +=dep;
        }
        System.out.println(dep+name);
        for(Folder e:folders){
            e.display(depth+1);
        }
        
        
    }
    public ArrayList<Folder> getFolders(){return folders;}
    
    public int getFolderSize(Folders fd,int size){
        for(Folder e:fd.getFolders()){
            if(e instanceof FileObject){
                FileObject e0 = (FileObject) e;
                size += Integer.valueOf(e0.getSize());
            }else if(e instanceof Folders){
                Folders e0 = (Folders) e;
                return size+getFolderSize(e0, size);
            }
        }
        return size;
    }
}
