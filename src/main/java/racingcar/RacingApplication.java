package racingcar;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        int numberOfCar = InputView.inputNumber(InputView.numberOfCar());
        int tryCntInput = InputView.inputNumber(InputView.tryCntInput());
        game.start(new InputValue(numberOfCar, tryCntInput));
    }
}
