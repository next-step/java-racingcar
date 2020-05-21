package me.daeho.step5;

import me.daeho.step5.view.InputView;
import me.daeho.step5.view.ResultView;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(InputView.create(), ResultView.create());

        racingGameController.start();
        racingGameController.run();
        racingGameController.winners();
    }
}
