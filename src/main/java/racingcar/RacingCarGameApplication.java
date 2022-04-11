package racingcar;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        String[] carNames = inputView.insertRacingCarName();
        int totalRacingRound = inputView.insertTotalRacingRound();

        RacingGame racingGame = new RacingGame(carNames);

        for (int i = 0; i < totalRacingRound; i++) {
            racingGame.roundStart(randomNumberGenerator);
            resultView.roundLogTrace(racingGame.getRacingCars());
        }

        racingGame.winnersOfTheRace();
    }
}
