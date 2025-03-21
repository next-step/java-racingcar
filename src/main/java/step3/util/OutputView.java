package step3.util;

import step3.game.Car;
import step3.game.GameRound;

import java.util.List;

public class OutputView {

    public static void printResult(List<GameRound> result, List<String> winners) {
        System.out.println("실행결과");
        printHistories(result);
        printWinners(winners);
    }

    private static void printHistories(List<GameRound> result) {
        for (GameRound round : result) {
            for (Car car : round.getRound()) {
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }
    }

    private static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
