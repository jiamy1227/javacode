package javaee.Reflection;


import java.util.ArrayList;
import java.util.List;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = String.class;
        Class cls2 = Class.forName("java.lang.String");
        System.out.println(cls.getName());
        System.out.println(cls2.getName());

        List<String> list = new ArrayList<>();
    }
}
