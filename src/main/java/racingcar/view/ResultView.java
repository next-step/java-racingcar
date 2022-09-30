package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String POSITION_MARK = "-";

    private ResultView() {
    }

    public static void printResultMessage() {
        System.out.println("\n" + RESULT_MESSAGE + "\n");
    }

    public static void print(Cars cars) {
        List<Car> values = cars.getValues();
        for (Car value : values) {
            ResultView.printPositionMark(value.getPosition());
        }
        System.out.println();
    }

    private static void printPositionMark(int position) {
        System.out.println(POSITION_MARK.repeat(position));
    }
}
