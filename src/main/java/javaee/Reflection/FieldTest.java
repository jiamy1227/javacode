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

            Class c2 = Person.class;
            Field f2= c2.getDeclaredField("name");
            f2.setAccessible(true);
            //System.out.println(p.getName());


            System.out.println(c==c2);
            System.out.println(c.equals(c2));

            System.out.println(c.getSuperclass());

            Class c3 = Integer.class;
            Class[] cs = c3.getInterfaces();
            for(Class s :cs){
                System.out.println(s);
            }
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