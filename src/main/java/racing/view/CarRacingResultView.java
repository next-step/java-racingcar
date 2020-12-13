package racing.view;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class CarRacingResultView {

    public static void printRacingResultHeader() {
        System.out.println("실행 결과");
    }

    public static IntConsumer printRacingResult() {
        return distance -> {
            char[] chars = new char[distance];
            Arrays.fill(chars, '-');
            System.out.println(new String(chars));
        };
    }

    public static Runnable printRaceFooter() {
        return System.out::println;
    }
}
