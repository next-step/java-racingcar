package racingcar.fixture;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.strategy.MockRandomMovingStrategy;

import java.util.Arrays;
import java.util.Collections;

public class RacingCarFixture {

    public static final RacingCar MOVABLE_RACING_CAR =
            new RacingCar(MockRandomMovingStrategy.MOVABLE_RANDOM_MOVE_STRATEGY);

    public static final RacingCar IMMOVABLE_RACING_CAR =
            new RacingCar(MockRandomMovingStrategy.IMMOVABLE_RANDOM_MOVE_STRATEGY);


    public static final RacingCars RACING_CARS =
            RacingCars.from(Collections.unmodifiableList(Arrays.asList(MOVABLE_RACING_CAR, IMMOVABLE_RACING_CAR)));
}
