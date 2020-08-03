package racing.view;

import java.util.Arrays;

public class RacingResultView {

    private static final char CAR_RACING_PRINT_SYMBOL = '-';

    public static void printHeader() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public static void printCarMovedDistance(int distance) {
        char[] array = new char[distance];
        Arrays.fill(array, CAR_RACING_PRINT_SYMBOL);
        System.out.println(array);
    }

    public static void printFooter() {
        System.out.println();
    }
}
