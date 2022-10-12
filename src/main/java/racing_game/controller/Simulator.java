package racing_game.controller;

import racing_game.core.Positive;
import racing_game.core.SnapShot;
import racing_game.domain.Cars;
import racing_game.domain.Distances;
import racing_game.domain.MovingStrategy;
import racing_game.domain.RandomGenerator;
import racing_game.domain.RandomMovingStrategy;

public class Simulator {

    public SnapShot simulate(Positive tryCount, Positive carCount) {
        Cars cars = Cars.create(carCount);
        SnapShot snapShot = new SnapShot();

        RandomGenerator randomGenerator = RandomGenerator.create();
        MovingStrategy movingStrategy = new RandomMovingStrategy(randomGenerator);
        for (int i = 0; i < tryCount.toInt(); i++) {
            cars.moveAll(movingStrategy);
            snapShot.capture(new Distances(cars));
        }
        return snapShot;
    }

}
