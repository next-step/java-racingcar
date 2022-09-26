package step3;

import step3.models.Game;
import step3.ui.InputView;
import step3.ui.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int carNumber = inputView.inputCarNumber();
        int tryNumber = inputView.inputTryNumber();

        Game game = new Game(carNumber, tryNumber);

        outputView.printResult(game.play());
    }
}
