package racing.io;

import java.util.List;
import java.util.stream.Collectors;
import racing.model.Car;

public class Viewer {

    private static final String RESULT_OUTPUT_GUIDE = "실행 결과";
    private static final String WINNER_OUTPUT_SUFFIX = "가 최종 우승했습니다.";
    private static final String DEFAULT_DELIMITER = ", ";

    public void printBeforeRacing(List<Car> cars) {
        System.out.println(RESULT_OUTPUT_GUIDE);
        printCars(cars);
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String result = winners.stream()
                                .map(Car::getName)
                                .collect(Collectors.joining(DEFAULT_DELIMITER));
        System.out.println(result + WINNER_OUTPUT_SUFFIX);
    }

}
