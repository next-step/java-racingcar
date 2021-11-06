package step3.view;

import step3.domain.Car;

import java.util.List;

public class ResultView {

    private static final String START_OUTPUT_MESSAGE = "실행 결과";
    private static final String DASH = "-";

    public static void start() {
        System.out.println(START_OUTPUT_MESSAGE);
    }

    public static void result(List<Car> cars) {
        roundResult(cars);
    }

    private static void roundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(repeatDash(car.getPosition()));
        }
        System.out.println();
    }

    private static String repeatDash(int position) {
        StringBuilder sb = new StringBuilder();
        for (int count = 0; count < position; count++) {
            sb.append(DASH);
        }
        return sb.toString();
    }
}
