package racingcar;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        String namesOfCar = (InputView.nameOfCars());
        int tryCntInput = InputView.inputNumber(InputView.tryCntInput());
        game.start(new InputValue(namesOfCar, tryCntInput));
    }
}
