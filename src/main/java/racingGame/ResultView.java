package racingGame;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(drawLine(car));
        }
        System.out.println();
    }

    private static String drawLine(Car car) {
        int position = Math.max(0, car.position());
        return car.name() + " : " + "-".repeat(position);
    }

    public static void printWinners(List<String> winners) {
        String joined = String.join(", ", winners);
        System.out.println(joined + "가 최종 우승했습니다.");
    }
}
