package carRace.view;

import static java.util.stream.Collectors.joining;

import carRace.domain.car.CarGroups;
import carRace.domain.car.CarName;
import carRace.domain.car.CarNames;
import java.util.stream.IntStream;

public class OutputView {

    private static final String RACE_MARK = "_";

    private static final String COLON = " : ";

    private OutputView() {
    }

    public static void printRaceResult(CarGroups cars) {
        cars.getCarGroups().stream().forEach(car -> {
            System.out.print(car.getCarName().getCarName() + COLON);
            IntStream.range(0, car.getMoveDistance().getMoveDistance())
                .forEach(count -> System.out.print(RACE_MARK));
            System.out.println();
        });
        System.out.println();
    }

    public static void printWinnersResult(CarNames carNames) {
        System.out.println(carNames.getCarNames()
            .stream()
            .map(CarName::getCarName)
            .collect(joining(", ", "", "가 최종 우승했습니다.")));
    }
}
