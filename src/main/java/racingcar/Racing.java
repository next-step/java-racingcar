package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Racing {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();

        int numberOfCar = inputView.getNumber();
        int playCount = inputView.getCount();

        ResultView resultView = new ResultView();
        resultView.resultRacing(playCount, numberOfCar);
    }
}
