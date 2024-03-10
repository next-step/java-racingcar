package racing.controller;

import racing.model.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {
    private RacingGame racingGame;
    private int cars;
    private int attempts;
    private InputView inputView;
    private ResultView resultView;

    public void run() {
        init();
        setValues();
        RacingGame racingGame = new RacingGame(cars);
        ResultView resultView = racingGame.getResult(attempts);
        System.out.println(resultView.getResult());
    }

    private void init() {
        inputView = new InputView();
    }

    private void setValues() {
        cars = inputView.inputNumber("자동차 대수는 몇 대 인가요?");
        attempts = inputView.inputNumber("시도할 회수는 몇 회 인가요?");
    }

}
