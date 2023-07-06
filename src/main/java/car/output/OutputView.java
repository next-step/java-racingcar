package car.output;

import car.domain.CarResult;
import java.util.List;
import car.domain.Car;
import car.domain.Cars;
import java.util.stream.Collectors;

public final class OutputView {

    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printResult() {
        System.out.println(EXECUTE_RESULT_MESSAGE);
    }

    public static void printEachRaceResult(final Cars cars) {
        cars.getCars().forEach(car -> System.out.println(new CarResult(car)));
        System.out.println();
    }

    public static void printWinner(final List<Car> winner) {
        System.out.print(winner.stream()
            .map(Car::getName)
            .collect(Collectors.joining(",")));
        System.out.println(FINAL_WINNER_MESSAGE);
    }
}