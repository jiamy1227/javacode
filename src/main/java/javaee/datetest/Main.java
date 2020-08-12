package javaee.datetest;

import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getYear()+1900);
        System.out.println(date.getMonth()+1);
        System.out.println(date.getDay());
        System.out.println(date.getDate());

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate  = LocalDate.now();
        LocalTime localTime  = LocalTime.now();

        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);

        DateTimeFormatter dateTimeFormatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(localDateTime));

    }
}
