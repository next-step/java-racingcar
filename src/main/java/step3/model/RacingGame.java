package step3.model;

public class RacingGame {

    private final int tryCount;
    private final Cars cars;

    public RacingGame(Count tryCount, Count carCount, TryStrategy tryStrategy) {
        this.tryCount = tryCount.getCount();
        this.cars = new Cars(carCount.getCount(), tryStrategy);
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
