package step3.service;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.GameResult;
import step3.strategy.MovingStrategy;
import step3.strategy.RandomNumMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    private final static MovingStrategy movingStrategy = new RandomNumMovingStrategy();

    public static GameResult playRound(int carCount, int roundCount) {
        Cars cars = makeCars(carCount);
        GameResult result = new GameResult();
        for (int i = 0; i < roundCount; i++) {
            result.saveRoundResult(race(cars));
        }

        return result;
    }

    private static List<Integer> race(Cars cars) {
        List<Integer> resultPerRound = new ArrayList<>();
        for (Car car : cars.carList()) {
            car.move(movingStrategy);
            resultPerRound.add(car.getDistance());
        }
        return resultPerRound;
    }


    private static Cars makeCars(int carCount) {
        Cars cars = new Cars();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
