package racing.controller;

import racing.model.Car;
import racing.model.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class RacingController {
    private int cars;
    private int attempts;
    private InputView inputView;
    private ResultView resultView;

    public void run() {
        init();
        setValues();
        RacingGame racingGame = new RacingGame(cars);
        List<Car> raceDoneCars = racingGame.getResult(attempts);
        String result = resultView.getResultView(raceDoneCars, attempts);
        System.out.println(result);
    }

    private void init() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    private void setValues() {
        cars = inputView.inputNumber("자동차 대수는 몇 대 인가요?");
        attempts = inputView.inputNumber("시도할 회수는 몇 회 인가요?");
    }

}
