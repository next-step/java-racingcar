package racingcar.model;

import racingcar.CarList;

public class ResultView {
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String BAR = "-";

    public static void printStartComment() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void print(CarList cars) {
        cars.currentCars().forEach(car -> System.out.println(BAR.repeat(car.currentPosition())));
        System.out.println();
    }
}
