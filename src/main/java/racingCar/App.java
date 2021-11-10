package racingCar;

import racingCar.ui.InputView;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        new RacingCarGame(inputView.inputCarNames(), inputView.inputTryTimes()).playRace();
    }
}
