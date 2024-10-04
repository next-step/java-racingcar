package racingcar;

import java.util.List;

public class ResultView {
    public static void printMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult() {
        for (Car car : RacingGame.cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners() {
        List<Car> winners = Winner.getWinners();
        StringBuilder winnerNames = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                winnerNames.append(", ");
            }
        }
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
