package racing.view;

import racing.domain.CarContext;

import java.util.Arrays;
import java.util.function.Consumer;

public class CarRacingResultView {

    public static void printRacingResultHeader() {
        System.out.println("\n실행 결과");
    }

    public static Consumer<CarContext> printRacingResult() {
        return carContext -> {
            char[] chars = new char[carContext.getMovedDistance()];
            Arrays.fill(chars, '-');
            System.out.println(carContext.getName() + " : " + new String(chars));
        };
    }

    public static Runnable printRaceFooter() {
        return System.out::println;
    }

    public static void printRacingWinners(String[] winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
