package racingcar4.view;

import racingcar4.model.RacingGame;

import java.util.List;

public class ResultView {

    public static void startGame() {
        System.out.println("\n실행 결과");
    }

    public static void printOneTurn(RacingGame game) {
        printCarsPosition(game);
        System.out.println();
    }

    private static void printCarsPosition(RacingGame game) {
        int[] positions = game.getCarsPosition();
        String[] names = game.getCarsName();
        for (int i=0; i<positions.length; i++) {
            System.out.println(names[i] + " : " + "-".repeat(positions[i]));
        }
    }

    public static void printVictoryCars(RacingGame game) {
        List<String> names = game.victoryCars();

        for (int i=0; i<names.size(); i++) {
            System.out.print(names.get(i));
            plusComma(names.size(), i+1);
        }
        System.out.print("가 최종 우승했습니다.");
    }

    private static void plusComma(int length, int idx) {
        if (idx<length) {
            System.out.print(", ");
        }
    }
}
