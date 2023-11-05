package step3;

import static step3.presentation.InputView.scanAndGetValues;

import step3.application.SimpleRacingCarGame;
import step3.presentation.InputView;
import step3.presentation.OutputView;

public class RacingCarGameMain {

        public static void main(String args[]) {
                InputView inputValue = scanAndGetValues();
                SimpleRacingCarGame game = new SimpleRacingCarGame(inputValue.getCarCnt(), inputValue.getRound());

                OutputView outputView = new OutputView(game.start());
                outputView.printResult();
        }
}
