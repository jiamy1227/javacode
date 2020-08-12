package javaee.IO;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\jiamy\\temp\\io\\dir1");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        if(!file.isDirectory()){
            file.mkdir();
        }

        file = new File("E:\\jiamy\\temp\\io\\dir1\\abc");
        if(file.isFile()){
            file.delete();
        }

        file.createNewFile();


        Path path = Paths.get("E:\\jiamy\\temp\\io\\dir1");
        System.out.println(path.toAbsolutePath());
        for(Path p:path.toAbsolutePath()){
            System.out.println(p);
        }
    }
}
