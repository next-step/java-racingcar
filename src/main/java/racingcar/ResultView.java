package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void printMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult() {
        for (Car car : Cars.getCars()) {
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getDistance()));
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners() {
        List<Car> winners = Winner.getWinners();
        List<String> winnerNames = new ArrayList<>();

        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
