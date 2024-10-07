package racingcar;

import java.util.List;

public class ResultView {

    private static final String symbol = "-";

    public static void printResult(Cars cars, int loop) {
        System.out.println("실행결과");
        for (int i = 0; i < loop; i++) {
            cars.round();
            printAll(cars.getCarList());
        }
    }

    private static void printAll(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getStatus(symbol));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }


}
