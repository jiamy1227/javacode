package javaee.lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 创建Stream
 */
public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        System.out.println();
        stream.forEach(System.out::println);

        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        Arrays.asList();
        Stream<String> stream2  = list.stream();

        Pattern p = Pattern.compile("\\s+");
        Stream<String> s = p.splitAsStream("The quick brown fox jumps over the lazy dog");
        List<String> list2 = new ArrayList<>();
        s.forEach(list2::add);
    }
}
