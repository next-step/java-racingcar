package racingCar;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView keyboardInput = InputView.getInputView();

        RacingCars cars = new RacingCars(keyboardInput.nameOfCars());
        int numberOfRounds = keyboardInput.numberOfRounds();
        RacingGame game = new RacingGame(cars, numberOfRounds);

        game.start();

        ResultView.printResult(game);
    }
}