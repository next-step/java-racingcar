package racingcar;

public class RacingGameApplication {

    public static void main(String[] args) throws CloneNotSupportedException {
        String[] carNames = RacingGameInput.takeCarNames();
        int numberOfTimes = RacingGameInput.takeNumberOfTimes();

        RacingGame racingGame = new RacingGame(carNames);

        for (int i = 0; i < numberOfTimes; i++) {
            RacingGameOutput.showRaceOf(racingGame.play());
        }

        RacingGameOutput.showFinalWinner(racingGame.determineWinners());
    }
}
