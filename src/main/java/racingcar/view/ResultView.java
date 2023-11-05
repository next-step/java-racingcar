package racingcar.view;

import racingcar.model.RacingGame;

public class ResultView {

    public static void renderCars(RacingGame game, int count) {
        System.out.println("실행 결과");
        game.printOnce();
        System.out.println();
        for (int i = 0; i < count; i++) {
            game.moveOnce();
            game.printOnce();
            System.out.println();
        }
    }
}