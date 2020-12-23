package step3;

import step3.domain.RacingGame;
import step3.domain.rule.RandomMoveRule;
import step3.view.InputView;
import step3.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String[] carNames = inputView.getCarNames();
        int roundCount = inputView.getRoundCount();

        RacingGame racingGame = new RacingGame(roundCount, carNames, new RandomMoveRule());

        racingGame.play();

        outputView.printResult(racingGame.getCars(), roundCount);
    }
}
