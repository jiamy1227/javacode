package javaee.collection.equals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Xiao Ming"));
        list.add(new Person("Xiao Hong"));
        list.add(new Person("Bob"));

        System.out.println(list.contains(new Person("Bob"))); // false

        Objects.equals("a","a");
        Person a = new Person("Xiao Ming");

        boolean b = a instanceof Person;
    }
}

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
}
