package step4.view;

import step4.domain.Car;
import step4.domain.Cars;

import java.util.List;

public class ResultView {
    private static final String RESULT_START_MESSAGE = "실행 결과";

    public static void printResultStartMessage() {
        System.out.println("");
        System.out.println(RESULT_START_MESSAGE);
    }

    public static void printPosition(final Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car);
        }
        System.out.println("");
    }

    public static void printWinners(final Cars cars) {
        List<String> winners = cars.getWinnerNames();
        System.out.println(String.format("%s가 최종 우승 했습니다.", String.join(", ", winners)));
    }
}
