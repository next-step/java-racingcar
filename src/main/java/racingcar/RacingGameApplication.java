package racingcar;

public class RacingGameApplication {

    public static void main(String[] args) {
        int numberOfCars = RacingGameInput.takeNumberOfCars();
        int numberOfTimes = RacingGameInput.takeNumberOfTimes();

        RacingGame racingGame = new RacingGame(numberOfCars);

        for (int i = 0; i < numberOfTimes; i++) {
            RacingGameOutput.showRacingGame(racingGame.play());
        }
    }
}
