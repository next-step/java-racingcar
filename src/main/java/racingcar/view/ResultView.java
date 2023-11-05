package racingcar.view;

import racingcar.model.RacingGame;

public class ResultView {

    public static void renderCars(RacingGame game, int count) {
        System.out.println("실행 결과");
        printDistance(game);
        System.out.println();
        for (int i = 0; i < count; i++) {
            game.moveOnce();
            printDistance(game);
            System.out.println();
        }
    }

    private static void printDistance(RacingGame game) {
        String[] distances = game.getCarsDistance();
        for (String distance : distances) {
            System.out.println(distance);
        }
    }
}