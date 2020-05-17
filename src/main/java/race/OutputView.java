package race;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class OutputView {

    private static final String PATH = "-";
    private static final int START_POSITION= 0;
    private OutputView() {}

    public static void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRacing(List<RacingCar> racingCars) {
        printRacingCars(racingCars);
        System.out.println();
    }

    private static void printRacingCars(List<RacingCar> racingCars) {
        racingCars.forEach(OutputView::printRacingCar);
    }

    private static void printRacingCar(RacingCar racingCar) {
        String result = IntStream.range(START_POSITION, racingCar.getPosition())
                        .mapToObj(position -> PATH)
                        .collect(Collectors.joining());
        System.out.println(result);
    }
}
