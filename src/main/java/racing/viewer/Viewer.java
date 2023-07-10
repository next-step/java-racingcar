package racing.viewer;

import java.util.List;
import racing.domain.Car;
import racing.domain.Cars;

public class Viewer {

    private static final String RESULT_OUTPUT_GUIDE = "실행 결과";
    private static final String WINNER_OUTPUT_SUFFIX = "가 최종 우승했습니다.";
    private static final String WINNER_OUTPUT_DELIMITER = ", ";

    public void printBeforeRacing(Cars cars) {
        System.out.println(RESULT_OUTPUT_GUIDE);
        printCars(cars);
    }

    public void printCars(Cars cars) {
        for (Car car : cars.getCars()) {
            printCar(car);
        }
        System.out.println();
    }

    public void printCar(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printWinners(List<String> winnerNames) {
        String result = String.join(WINNER_OUTPUT_DELIMITER, winnerNames);
        System.out.println(result + WINNER_OUTPUT_SUFFIX);
    }

}
