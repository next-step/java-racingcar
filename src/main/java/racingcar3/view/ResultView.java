package racingcar3.view;

import racingcar3.model.RacingGame;

public class ResultView {

    public static void playGame(RacingGame game) {
        printCarsPosition(game);
        System.out.println();
    }

    private static void printCarsPosition(RacingGame game) {
        int[] positions = game.getCarsPosition();
        for (int position : positions) {
            System.out.println("-".repeat(position));
        }
    }
}
