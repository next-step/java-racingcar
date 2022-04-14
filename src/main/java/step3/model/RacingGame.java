package step3.model;

public class RacingGame {

    private final int tryCount;
    private final Cars cars;

    public RacingGame(RacingConfig racingConfig) {
        this.tryCount = racingConfig.getTryCount().getCount();
        this.cars = new Cars(racingConfig.getCarCount(), racingConfig.getTryStrategy());
    }

    public GameResult race() {

        GameResult gameResult = new GameResult();

        for (int i = 0; i < tryCount; i++) {
            cars.tryOnceEach();
            EachTryResult eachTryResult = cars.getEachTryResult();
            gameResult.addTryResult(eachTryResult);
        }

        return gameResult;
    }
}
