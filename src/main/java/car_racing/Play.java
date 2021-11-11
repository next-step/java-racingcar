package car_racing;

public class Play {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int numberOfCars = inputView.showMessageAndGetNumberOfCars();
        int numberOfRound = inputView.showMessageAndGetNumberOfRound();

        CarRacingGame carRacingGame = new CarRacingGame(numberOfCars, numberOfRound);
        CarRacingResult carRacingResult = carRacingGame.play();

        outputView.showCarRacingGameOutput(carRacingResult);
    }
}
