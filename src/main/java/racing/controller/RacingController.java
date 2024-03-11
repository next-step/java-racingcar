package racing.controller;

import racing.model.Car;
import racing.model.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class RacingController {
    private String[] names;
    private int attempts;
    private InputView inputView;
    private ResultView resultView;

    public void run() {
        init();
        setValues();
        RacingGame racingGame = new RacingGame(names);
        List<Car> raceDoneCars = racingGame.getResult(attempts);
        String result = resultView.getResultView(raceDoneCars, attempts);
        System.out.println(result);
    }

    private void init() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    private void setValues() {
        names = inputView.inputStrings("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)");
        attempts = inputView.inputNumber("시도할 회수는 몇 회 인가요?");
    }

}
