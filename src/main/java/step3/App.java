package step3;

import step3.service.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

public class App {
    public static void main(String[] args) {
        InputView.inputValues();

        RacingGame race = new RacingGame(InputView.howManyCars(), InputView.getAttemps());

        ResultView.printByAttemps(race);
    }
}
