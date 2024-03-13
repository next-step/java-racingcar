package carRace.view;

import carRace.domain.Car;
import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    private static final String RACE_MARK = "_";

    private OutputView() {
    }

    public static void printRaceResult(List<Car> cars) {
        cars.stream().forEach(car -> {
            IntStream.range(0, car.moveCount())
                .forEach(count -> System.out.print(RACE_MARK));
            System.out.println();
        });
        System.out.println();
    }
}
