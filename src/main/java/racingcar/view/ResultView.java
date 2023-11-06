package racingcar.view;

import racingcar.model.RacingGame;

public class ResultView {

    public static void renderCars(RacingGame game) {
        printDistance(game);
        System.out.println();
    }
    
    private static void printDistance(RacingGame game) {
        int[] positions = game.getCarsPosition();
        for (int position : positions) {
            System.out.println("-".repeat(position));
        }
    }
}
