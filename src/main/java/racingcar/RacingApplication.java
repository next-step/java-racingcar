package racingcar;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.start(new InputValue(InputView.inputNumber(InputView.numberOfCar()), InputView.inputNumber(InputView.tryCntInput())));
    }
}
