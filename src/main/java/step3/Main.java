package step3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = inputView.run();
        ResultView resultView = new ResultView();
        resultView.printScore(racingGame.race(new RacingDice(), new ArrayList<>()), inputView.getCarCount());
    }
}
