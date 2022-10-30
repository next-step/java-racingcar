package racingCar;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView keyboardInput = InputView.getInputView();

        RacingCars cars = new RacingCars(keyboardInput.nameOfCars());
        int numberOfRounds = keyboardInput.numberOfRounds();

        RacingCars result = RacingGame.start(cars, numberOfRounds);

        ResultView.printResult(result);
    }
}