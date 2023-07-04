package racingcar;

import java.util.List;

public class OutputManager {

    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String RESULT_MESSAGE = "가 최종 우승했습니다.";

    public void printExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            printCar(car);
        }
        System.out.println();
    }

    public void printCar(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getDistance() + 1));
    }

    public void printWinnerNames(List<String> carNames) {
        System.out.println(String.join(", ", carNames) + RESULT_MESSAGE);
    }
}
