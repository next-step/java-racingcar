package carRace.view;

import carRace.domain.car.Car;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String RACE_MARK = "_";

    private static final String COLON = " : ";

    private OutputView() {
    }

    public static void printRaceResult(List<Car> cars) {
        cars.stream().forEach(car -> {
            System.out.print(car.carName() + COLON);
            IntStream.range(0, car.getMoveDistance().getMoveDistance())
                .forEach(count -> System.out.print(RACE_MARK));
            System.out.println();
        });
        System.out.println();
    }

    public static void printWinnersResult(List<String> carNames) {
        System.out.println(carNames.stream().collect(Collectors.joining(", ", "", "가 최종 우승했습니다.")));
    }
}
