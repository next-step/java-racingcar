package view;

import java.util.List;
import java.util.stream.Stream;

public class ResultView {

    public static void printOutputValue(Stream<String> race) {
        race.forEach(System.out::print);
        System.out.println();
    }

}
