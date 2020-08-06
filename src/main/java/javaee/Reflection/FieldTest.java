package javaee.Reflection;

import java.lang.reflect.Field;

public class FieldTest {

        public static void main(String[] args) throws Exception {
            Person p = new Person("Xiao Ming");
            System.out.println(p.getName()); // "Xiao Ming"
            Class c = p.getClass();
            Field f = c.getDeclaredField("name");
            f.setAccessible(true);
            f.set(p, "Xiao Hong");


            System.out.println(p.getName()); // "Xiao Hong"
        }

}
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}