package step3.model;

public class RacingGame {

    private final int tryCount;
    private final Cars cars;
    private final GameResult gameResult;

    public RacingGame(Count tryCount, Names names, TryStrategy tryStrategy) {
        this.tryCount = tryCount.getValue();
        this.cars = new Cars(names, tryStrategy);
        this.gameResult = new GameResult();
    }

    public GameResult race() {
        for (int i = 0; i < tryCount; i++) {
            cars.tryOnceEach();
            updateGameResult();
        }
        updateWinner();

        return gameResult;
    }

    private void updateGameResult() {
        EachTryResult eachTryResult = cars.getEachTryResult();
        gameResult.addTryResult(eachTryResult);
    }

    private void updateWinner() {
        gameResult.updateWinner();
    }
}
