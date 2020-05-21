package step5;

import step5.domain.CarFactory;
import step5.domain.RacingGame;
import step5.domain.ResultRecorder;
import step5.view.InputView;
import step5.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();

        RacingGame racingGame = RacingGame.of(inputView.getTryCount(), CarFactory.createCars(inputView.getNames()));
        racingGame.startGame();

        ResultRecorder recorder = racingGame.getResultRecorder();
        ResultView resultView = new ResultView();
        resultView.print(recorder.getResult(), recorder.findWinners());
    }
}
