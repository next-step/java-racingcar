package racing.view;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class CarRacingResultView {

    public static void printRacingResultHeader() {
        System.out.println("\n실행 결과");
    }

    public static BiConsumer<String, Integer> printRacingResult() {
        return (name, distance) -> {
            char[] chars = new char[distance];
            Arrays.fill(chars, '-');
            System.out.println(name + " : " + new String(chars));
        };
    }

    public static Runnable printRaceFooter() {
        return System.out::println;
    }

    public static void printRacingWinners(String[] winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
