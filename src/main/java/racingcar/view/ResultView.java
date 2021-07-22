package racingcar.view;

import racingcar.car.Car;

import java.util.List;

public class ResultView {

    private static final String MESSAGE_RESULT = "\n실행 결과";
    private static final String SYMBOL = "-";

    private ResultView() {
    }

    public static void show(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getPositionAsSymbol(car.getPosition()));
        }
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(MESSAGE_RESULT);
    }

    private static String getPositionAsSymbol(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(SYMBOL);
        }
        return stringBuilder.toString();
    }

}
