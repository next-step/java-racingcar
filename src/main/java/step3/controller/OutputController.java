package step3.controller;

import step3.domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputController {

    private static final String RUN_RESULT = "실행 결과";
    private static final String RACING_PAINT = "-";

    public static void runResult(Cars cars) {
        List<Integer> carsPosition = cars.getCarsPosition();
        carsPosition.forEach(position -> {
            System.out.println(Arrays.stream(new String[position])
                    .map(v -> RACING_PAINT)
                    .collect(Collectors.joining("")));
        });
        System.out.println("다음게임");
    }

    public static void endResult() {
        System.out.println(RUN_RESULT);
    }

}
