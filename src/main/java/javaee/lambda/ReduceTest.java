package javaee.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReduceTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        List<String> list =  new ArrayList<>();
        String a = "";
        stream.reduce(a,(l,s)->
            {
                //l.add(s);
                return l;
            }
            );
    }
}
