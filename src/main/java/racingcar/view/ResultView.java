package racingcar.view;

import racingcar.car.Car;

import java.util.List;

public class ResultView {

    private static final String MESSAGE_RESULT = "\n실행 결과";

    private ResultView() {
    }

    public static void show(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getPositionAsSymbol());
        }
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(MESSAGE_RESULT);
    }

}
