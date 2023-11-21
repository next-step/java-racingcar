package step4.service;

import step4.domain.Cars;
import step4.domain.GameResult;
import step4.strategy.MovingStrategy;
import step4.strategy.RandomNumMovingStrategy;
import step4.util.NameSplitter;

public class RacingCarService {
    private RacingCarService() {

    }
    public static final MovingStrategy movingStrategy = new RandomNumMovingStrategy();
    public static GameResult playRound(String nameString, int roundCount) {
        Cars cars = new Cars(NameSplitter.splitName(nameString), movingStrategy);
        GameResult result = new GameResult();
        for (int i = 0; i < roundCount; i++) {
            result.saveRoundResult(cars.race());
        }
        result.saveWinners(cars);

        return result;
    }
}
