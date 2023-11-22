package step4.service;

import step4.domain.*;
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
            result.saveRoundResult(race(cars));
        }

        findWinners(cars, result.winnerList());
        return result;
    }

    private static RoundResult race(Cars cars) {
        RoundResult roundResult = new RoundResult();
        for (Car car : cars.carList()) {
            car.move();
            roundResult.add(car.distance());
        }

        return roundResult;
    }

    private static void findWinners(Cars cars, Winners winners) {
        int maxDistance = cars.findMaxDistance();
        for (Car car : cars.carList()) {
            winners.addWinner(car, maxDistance);
        }
    }
}
