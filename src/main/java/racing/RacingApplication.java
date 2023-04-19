package racing;

import java.util.List;
import racing.domain.GameResult;
import racing.rule.RandomRacingRule;

import java.util.Scanner;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        List<String> carNameList = inputView.inputCarNames();
        int opportunity = inputView.inputOpportunity();

        RacingGame racingGame = new RacingGame(carNameList, new RandomRacingRule());
        GameResult result = racingGame.start(opportunity);
        RacingPrinter.drawResult(result);
    }
}
