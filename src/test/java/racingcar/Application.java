package racingcar;

import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        int time = InputView.askTime();
        int carCount = InputView.askCarCount();
    }
}
