package car;

public class RacingGame {

    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void playGame(Integer numberOfGames, Cars cars) {
        int totalCarCount = cars.getTotalCarCount();
        for (int i = 0; i < numberOfGames; i++) {
            cars.playGameByCars(randomNumberGenerator.makeRandomNumbers(totalCarCount));
            ResultView.outputEachGameResult(cars.getCars());
        }
    }
}
