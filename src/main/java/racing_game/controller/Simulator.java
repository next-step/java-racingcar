package racing_game.controller;

import java.util.List;
import racing_game.core.Positive;
import racing_game.domain.CarName;
import racing_game.domain.Cars;
import racing_game.domain.MovingStrategy;
import racing_game.domain.RandomGenerator;
import racing_game.domain.RandomMovingStrategy;
import racing_game.domain.SnapShot;

public class Simulator {

    public SnapShot simulate(Positive tryCount, List<CarName> carNames) {
        Cars cars = Cars.create(carNames);
        SnapShot snapShot = new SnapShot();

        RandomGenerator randomGenerator = RandomGenerator.create();
        MovingStrategy movingStrategy = new RandomMovingStrategy(randomGenerator);
        for (int i = 0; i < tryCount.toInt(); i++) {
            cars.moveAll(movingStrategy);
            snapShot.capture(cars);
        }
        snapShot.setWinner(cars.getCurrentWinners());
        return snapShot;
    }

}
