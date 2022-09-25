package racingGame;

import racingGame.racingRule.RacingRuleV1;

import java.util.List;
import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputParameters inputParameters = inputView.askInput(new Scanner(System.in));
        RacingRuleV1 racingRuleV1 = new RacingRuleV1();
        List<Car> playResult = new RacingGameV1(inputParameters).play(racingRuleV1);
        ResultView resultView = new ResultView();
        resultView.printRacingResult(playResult);
    }
}
