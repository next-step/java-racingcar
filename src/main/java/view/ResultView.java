package view;

import java.util.List;

public class ResultView {

    public static void printOutputValue(List<String> race) {
        race.stream().forEach(System.out::print);
        println();
    }

    public static void println() {
        System.out.println();
    }
}
