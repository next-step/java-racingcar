package racingcar;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        int racingCarCount = inputView.insertRacingCarCount();
        int totalRacingRound = inputView.insertTotalRacingRound();

        RacingGame racingGame = new RacingGame(racingCarCount, totalRacingRound, randomNumberGenerator);
        racingGame.raceStart();
    }
}
