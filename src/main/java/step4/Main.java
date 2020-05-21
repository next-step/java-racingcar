package step4;

import step4.domain.CarFactory;
import step4.domain.RacingGame;
import step4.domain.ResultRecorder;
import step4.view.InputView;
import step4.view.ResultView;

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
