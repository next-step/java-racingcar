package step4.controller;

import step4.domain.Car;
import step4.domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputController {

    private static final String RUN_RESULT = "실행 결과";
    private static final String RACING_PAINT = "-";
    private static final String WINNER_DELIMITER = ",";
    private static final String WINNER_RESULT = "가 최종 우승했습니다.";

    public static void runResult(Cars cars) {
        List<Car> carsStatus = getCars(cars);
        carsStatus.forEach(car -> {
            String carPositionPaint = Arrays.stream(new String[car.getCarPosition()])
                    .map(v -> RACING_PAINT)
                    .collect(Collectors.joining(""));
            System.out.println(car.getName() + " : " + carPositionPaint);
        });
        System.out.println("");
    }

    public static void printEndResult() {
        System.out.println(RUN_RESULT);
    }

    public static void printWinnerResult(Cars cars) {
        List<Car> carsStatus = getCars(cars);
        List<Integer> carPositions = getCarPositions(carsStatus);
        Integer topPosition = getTopPosition(carPositions);
        String topPositionCarName = getTopPositionCarName(carsStatus, topPosition);
        System.out.println(topPositionCarName + WINNER_RESULT );
    }

    private static List<Integer> getCarPositions(List<Car> carsStatus) {
        return carsStatus.stream()
                .map(Car::getCarPosition)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    private static String getTopPositionCarName(List<Car> carsStatus, Integer topPosition) {
        return carsStatus.stream()
                .filter(car -> car.getCarPosition() == topPosition)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private static Integer getTopPosition(List<Integer> carPositions) {
        return carPositions.get(carPositions.size() -1);
    }

    private static List<Car> getCars(Cars cars) {
        return cars.getCarsStatus();
    }
}
