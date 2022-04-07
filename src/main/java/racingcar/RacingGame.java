package racingcar;

public class RacingGame {

    private final int totalRound;
    private final ResultView resultView;
    private final RandomNumberGenerator randomNumberGenerator;

    private RacingCar[] racingCars;

    public RacingGame(int racingCarCount, int totalRound, RandomNumberGenerator randomNumberGenerator) {
        this.totalRound = totalRound;
        this.resultView = new ResultView();
        this.randomNumberGenerator = randomNumberGenerator;
        readyRacingCars(racingCarCount);
    }

    private void readyRacingCars(int racingCarCount) {
        racingCars = new RacingCar[racingCarCount];

        for (int i = 0; i < racingCars.length; i++) {
            racingCars[i] = new RacingCar();
        }
    }

    public void raceStart() {
        for (int i = 0; i < totalRound; i++) {
            roundStart();
            resultView.roundLogTrace(racingCars);
        }
    }

    private void roundStart() {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop(randomNumberGenerator.generateRacingRandomNumber());
        }
    }
}
