package me.daeho.step3;

import me.daeho.step3.ui.InputView;
import me.daeho.step3.ui.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.create();
        ResultView resultView = ResultView.create();

        int carCount = inputView.getCarCount();
        int time = inputView.getTime();

        RacingGame game = RacingGame.init(time, carCount);

        while(game.hasNext()) {
            resultView.showResult(game.move());
            game.next();
        }
    }
}
