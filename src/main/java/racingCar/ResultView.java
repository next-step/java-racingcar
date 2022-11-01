package racingCar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String TRACE_MARK = "-";

    public static void printResult(RacingCars cars) {
        System.out.println("실행 결과");

        printCars(cars);

        printWinners(cars);
    }

    private static void printWinners(final RacingCars cars) {

        List<String> winners = cars.winners()
                .stream()
                .map(RacingCar::name)
                .map(RacingCarName::toString)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    private static void printCars(RacingCars cars) {
        for (RacingCar car : cars.getCars()) {
            System.out.println(car.toView().toString());
        }
    }
}
