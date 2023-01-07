import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * Folder
 */
public abstract class Folder {
    protected String name;
    public Folder(String name){
        this.name = name;
    }
    public abstract void add(Folder fd);
    public abstract void remove(Folder fd);
    public abstract void display(int depth);
    public String toString(){return name;}


    public static long getFileKiloByte(String fileName) {

        Path path = Paths.get(fileName);

        try {

            // size of a file (in bytes)
            long bytes = Files.size(path);
            
            return bytes / 1024;

        } catch (IOException e) {
            e.printStackTrace();
            return 0L;
        }

    }
    
}