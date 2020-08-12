package javaee.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Map<Person,String> map = new HashMap<>();
        Person p = new Person("jiamy",20);
        Person p2 = new Person("jiamy",20);
        map.put(new Person("jiamy",20),"aaaa");
        map.put(new Person("masterj",22),"bbbb");
        map.put(p,"ccc");
        map.put(p2,"DDD");

        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey().toString()+":"+entry.getValue());
        }

        System.out.println(map.get(p));
        System.out.println(map.get(p2));
    }

}
