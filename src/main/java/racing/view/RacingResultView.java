package racing.view;

import java.util.Arrays;

public class RacingResultView {

    private static final char CAR_RACING_PRINT_SYMBOL = '-';

    public static void printHeader() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public static void printCarMovedDistance(String name, int distance) {
        char[] array = new char[distance];
        Arrays.fill(array, CAR_RACING_PRINT_SYMBOL);
        System.out.println(name + " : " + new String(array));
    }

    public static void printFooter() {
        System.out.println();
    }

    public static void printRaceWinners(String[] winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
