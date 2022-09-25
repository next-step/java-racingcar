package racinggame;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int number = inputView.inputUserCarCount();
        int tryCount = inputView.inputUserTryCount();

        RacingCar racingCar = new RacingCar(number);

        resultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            resultView.printStatus(racingCar.racing());
        }
    }
}
