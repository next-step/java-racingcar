package racingGame;

import racingGame.racingRule.RacingRuleDefault;
import racingGame.view.InputView;
import racingGame.view.ResultView;

import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {

        InputParameters inputParameters = InputView.askInput(new Scanner(System.in));
        RacingRuleDefault racingRuleDefault = new RacingRuleDefault();
        Cars playResult = new RacingGame(inputParameters).play(racingRuleDefault);
        ResultView.printRacingResult(playResult);
    }
}
