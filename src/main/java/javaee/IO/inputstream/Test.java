package javaee.IO.inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        try(InputStream fis = new FileInputStream("E:\\jiamy\\temp\\io\\dir1\\input")) {
            int i =0;
            while(i!=-1){
                i=fis.read();
                char c = (char) i;
                System.out.println(c);
            }
        }
    }
}
