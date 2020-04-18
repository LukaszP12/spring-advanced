package pl.strefakursow.springadvanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasAndStreams {

    public static void main(String[] args) {

      /*  Thread thread = new Thread(() -> System.out.println("Informacja z osobnego wątku"));
        Thread thread1 = new Thread(() -> System.out.println("Informacja z drugiego wątku"));

        thread.start();
        thread1.start();
        System.out.println("Informacja z metody main"); */

      List<Integer> numbers = Arrays.asList(52,17,44,67,98,60,21,18,57,102);

      int result = 0;

        System.out.println(
                numbers.stream()
                        .filter(x -> x % 2 == 0)
                        .mapToInt(x -> x * 2)
                        .sum()
        );


    }

}
