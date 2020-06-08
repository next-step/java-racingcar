package racingcar;

import racingcar.racinggame.RacingGameView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGameView racingGameview = new RacingGameView();
        racingGameview.init();
        racingGameview.layoutCarQuestion();
        racingGameview.layoutGameTryQuestion();
    }

}