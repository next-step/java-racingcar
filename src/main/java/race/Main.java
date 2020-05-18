package race;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.of();

        RacingGame racingGame = RacingGame.create(inputView.getTime(), new RandomMovingStrategy());
        racingGame.readyRacingCars(inputView.getCountOfCar());
        racingGame.startRacing();
    }
}
