package racing;

import racing.domain.GameResult;
import racing.rule.RandomRacingRule;

import java.util.Scanner;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int carCount = inputView.inputCarCount();
        int opportunity = inputView.inputOpportunity();

        RacingGame racingGame = new RacingGame(carCount, new RandomRacingRule());
        GameResult result = racingGame.start(opportunity);
        RacingPrinter.drawPositions(result);
    }
}
