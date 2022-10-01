package racingGame;

import racingGame.domain.Cars;
import racingGame.domain.InputValue;
import racingGame.domain.RacingGame;
import racingGame.domain.racingRule.RacingRuleDefault;
import racingGame.view.InputView;
import racingGame.view.ResultView;

import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {

        InputValue inputValue = InputView.askInput(new Scanner(System.in));
        RacingRuleDefault racingRuleDefault = new RacingRuleDefault();
        Cars playResult = new RacingGame(inputValue).play(racingRuleDefault);
        ResultView.printRacingResult(playResult);
    }
}
