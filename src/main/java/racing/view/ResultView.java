package racing.view;

import racing.domain.RacingCar;

import java.util.List;

public class ResultView {
    private static final String HYPHEN = "-";
    private static final String LINE_BREAK = "\n";

    public static void printGameResultTitle() {
        System.out.println(LINE_BREAK + "실행 결과");
    }

    public static void printCarCurrentPosition(List<RacingCar> racingCars) {
        racingCars.stream()
                .map(car -> positionToString(car.getPosition()))
                .forEach(System.out::println);
        System.out.print(LINE_BREAK);
    }

    private static String positionToString(int position) {
        return HYPHEN.repeat(Math.max(0, position));
    }
}
