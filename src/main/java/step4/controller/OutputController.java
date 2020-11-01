package step4.controller;

import step4.domain.Car;
import step4.domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputController {

    private static final String RUN_RESULT = "실행 결과";
    private static final String RACING_PAINT = "-";

    public static void runResult(Cars cars) {
        List<Car> carsStatus = cars.getCarsStatus();
        carsStatus.forEach(car -> {
            String carPositionPaint = Arrays.stream(new String[car.getCarPosition()])
                    .map(v -> RACING_PAINT)
                    .collect(Collectors.joining(""));
            System.out.println(car.getName() + " : " + carPositionPaint);
        });
        System.out.println("");
    }

    public static void endResult() {
        System.out.println(RUN_RESULT);
    }

}
