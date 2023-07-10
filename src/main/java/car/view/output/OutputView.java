package car.view.output;

import java.util.List;
import car.model.Car;
import car.model.Cars;
import java.util.stream.Collectors;

public final class OutputView {

    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String CAR_RESULT_DELIMITER = " : ";
    private static final String POSITION_MARK = "-";


    public static void printResult() {
        System.out.println(EXECUTE_RESULT_MESSAGE);
    }

    private static String makeCarResult(Car carResult) {
        return new StringBuilder()
            .append(carResult.getName())
            .append(CAR_RESULT_DELIMITER)
            .append(POSITION_MARK.repeat(carResult.getPosition()))
            .toString();
    }

    public static void printEachRaceResult(final Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(makeCarResult(car));
        }
        System.out.println();
    }

    public static void printWinner(final List<Car> winner) {
        System.out.print(winner.stream()
            .map(Car::getName)
            .collect(Collectors.joining(",")));
        System.out.println(FINAL_WINNER_MESSAGE);
    }
}
