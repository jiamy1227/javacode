package javaee.lambda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        LocalDate date = LocalDate.parse("2020-01-01",formatter);
        //System.out.println(date.getDayOfMonth());

        List<DayOfWeek> list= Arrays.asList("2020-03-04","2020-05-06","2020-08-09")
                .stream()
                .map(s->LocalDate.parse(s,DateTimeFormatter.ISO_LOCAL_DATE))
                .map(s->s.getDayOfWeek())
                .filter(s -> s != null)
                .collect(Collectors.toList());
                //.forEach(System.out::println);

        for(DayOfWeek d:list){
            System.out.println(d.toString());
        }

    }
}
