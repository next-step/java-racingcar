package step3.model;

import step3.view.dto.RacingConfigDto;

public class RacingGame {

    private final int tryCount;
    private final Cars cars;

    public RacingGame(RacingConfigDto racingConfigDto) {
        this.tryCount = racingConfigDto.getTryCount();
        this.cars = new Cars(racingConfigDto.getCarCount(), racingConfigDto.getTryStrategy());
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
