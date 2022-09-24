package racinggame;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int number = inputView.inputUserCarCount();
        int tryCount = inputView.inputUserTryCount();

        RacingCar racingCar = new RacingCar(number);

        for (int i = 0; i < tryCount; i++) {
            racingCar.racing();
        }
    }
}
