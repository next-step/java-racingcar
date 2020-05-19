package me.daeho.step3;

import me.daeho.step3.rule.DefaultForwardRule;
import me.daeho.step3.ui.InputView;
import me.daeho.step3.ui.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView
                .create()
                .inputCarNames()
                .inputTime();

        RacingGame game = RacingGame.init(new DefaultForwardRule(), inputView.getCarNames(), inputView.getTime());

        while(game.hasNext()) {
            ResultView.showResult(game.move());
        }

        ResultView.showWinners(game.winningCars());
    }
}
