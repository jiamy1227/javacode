package javaee.packageTest;
import javax.xml.XMLConstants;
public class Test {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);
        System.out.println("-------------"
        );

        int i = 0x31;
        int i2 = 061;
        int i3 = 0b10;
        String s2 =String.valueOf(i);
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(s2);


    }
}
