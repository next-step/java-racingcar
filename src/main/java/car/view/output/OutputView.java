package car.view.output;

import car.model.Car;
import car.model.CarResult;
import java.util.List;
import java.util.stream.Collectors;

public final class OutputView {

    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String CAR_RESULT_DELIMITER = " : ";
    private static final String POSITION_MARK = "-";


    public static void printExecuteResult() {
        System.out.println(EXECUTE_RESULT_MESSAGE);
    }

    private static String makeCarResult(CarResult carResult) {
        return carResult.getName() + (CAR_RESULT_DELIMITER) +
            (POSITION_MARK.repeat(carResult.getPosition()));
    }

    public static void printEachRaceResult(final List<CarResult> carResults) {
        for (CarResult car : carResults) {
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
