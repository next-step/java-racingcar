package racingcar;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        String[] carNames = inputView.insertRacingCarName();
        int totalRacingRound = inputView.insertTotalRacingRound();

        RacingGame racingGame = new RacingGame(carNames, totalRacingRound, randomNumberGenerator);
        racingGame.raceStart();
    }
}
