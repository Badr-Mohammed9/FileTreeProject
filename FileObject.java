public class FileObject extends Folder {
    private String size;

    public String getSize(){return size;}
    public void setFileSize(String size){this.size=size;}
    public FileObject(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void add(Folder fd) {
        // TODO Auto-generated method stub
        System.out.println("Cannot add to a file");
        
    }

    @Override
    public void remove(Folder fd) {
        // TODO Auto-generated method stub
        System.out.println("Cannot add to a file");
        
    }

    public void display(int depth) {
        // TODO Auto-generated method stub
        String dep = "-";
        for (int i = 0; i < depth; i++) {
            dep +=dep;
        }
        System.out.println(dep+name);
        
        
    }
    
}
