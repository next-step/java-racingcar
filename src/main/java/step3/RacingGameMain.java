package step3;

import step3.execute.RacingGame;
import step3.view.InputView;
import step3.view.OutputView;

public class RacingGameMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.runInputView();

        RacingGame program = new RacingGame(inputView.getNumberOfCars(), inputView.getTrialCounts());
        OutputView.showResultOfGame(program.run());
    }
}
