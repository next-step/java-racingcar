package racingcar.view;

import racingcar.domain.Car;

public class ResultView {
    private static final String DISTANCE_PATTERN = "-";

    public static void printCarDistanceWithName(Car car) {
        System.out.printf("%s : ", car.getCarName());
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.print(DISTANCE_PATTERN);
        }
        System.out.println();
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printWinners(String winners) {
        System.out.printf("%s가 최종 우승했습니다.", winners);
    }

}
