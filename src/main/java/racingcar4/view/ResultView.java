package racingcar4.view;

import racingcar4.model.RacingGame;

import java.util.List;

public class ResultView {

    public static void startGame() {
        System.out.println("\n실행 결과");
    }

    public static void printOneTurn(RacingGame game) {
        printCarsPosition(game);
    }

    private static void printCarsPosition(RacingGame game) {
        game.resultCar();
        System.out.println();
    }

    public static void printVictoryCars(RacingGame game) {
        System.out.println(String.join(",", game.victoryCars()) + "가 최종 우승했습니다.");
    }
}
