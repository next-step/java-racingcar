package step4.controller;

import step4.domain.Car;
import step4.domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputController {

    private static final String RUN_RESULT = "실행 결과";
    private static final String RACING_PAINT = "-";

    private static final String WINNER_RESULT = "가 최종 우승했습니다.";

    public static void runResult(Cars cars) {
        List<Car> carsStatus = getCarList(cars);
        carsStatus.forEach(car -> {
            String carPositionPaint = Arrays.stream(new String[car.getPosition()])
                    .map(v -> RACING_PAINT)
                    .collect(Collectors.joining(""));
            System.out.println(car.toString() + " : " + carPositionPaint);
        });
        System.out.println("");
    }

    public static void printEndResult() {
        System.out.println(RUN_RESULT);
    }

    public static void printWinnerResult(String winnerNames) {

        System.out.println(winnerNames + WINNER_RESULT );
    }

    private static List<Car> getCarList(Cars cars) {
        return cars.getCarList();
    }



}
