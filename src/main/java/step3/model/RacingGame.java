package step3.model;

public class RacingGame {

    private final int tryCount;
    private final Cars cars;

    public RacingGame(Count tryCount, Names names, TryStrategy tryStrategy) {
        this.tryCount = tryCount.getValue();
        this.cars = new Cars(names, tryStrategy);
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
