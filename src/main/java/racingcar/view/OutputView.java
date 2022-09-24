package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String RACING_RESULT = "실행 결과";

    public static void printRacingResultTitle(){
        System.out.println(RACING_RESULT);
    }

    public static void showRacingResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.showDistanceGraph());

        }
        System.out.println();
    }
}
