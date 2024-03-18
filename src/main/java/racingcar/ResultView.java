package racingcar;

import java.util.List;

public class ResultView {

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            printCarResult(car);
        }
    }

    public static void printCarResult(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinners(List<String> winnerList) {
        System.out.println(String.join(",", winnerList) + "가 최종 우승했습니다.");
    }
}
