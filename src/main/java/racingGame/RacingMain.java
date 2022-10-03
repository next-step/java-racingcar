package racingGame;

import racingGame.domain.Cars;
import racingGame.domain.InputValue;
import racingGame.racingRule.RacingRuleDefault;
import racingGame.view.InputView;
import racingGame.view.ResultView;

import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }
}
