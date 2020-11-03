package study.racingcar;

import study.racingcar.car.moving.RandomValueMovingStrategy;
import study.racingcar.configuration.CommandLineGameConfiguration;
import study.racingcar.view.CommandLineInputView;
import study.racingcar.view.DefaultResultView;

public class RacingGameMain {

    public static void main(String[] args) {

        CommandLineGameConfiguration gameConfiguration = new CommandLineGameConfiguration(
                new CommandLineInputView()
                , RandomValueMovingStrategy.getInstance());

        RacingGame racingGame = new RacingGame(gameConfiguration, new DefaultResultView());
        GameResult gameResult = racingGame.startGame();
    }
}
