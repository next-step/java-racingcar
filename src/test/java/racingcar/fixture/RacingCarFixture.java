package racingcar.fixture;

import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.strategy.MockRandomMovingStrategy;

import java.util.Arrays;
import java.util.Collections;

import static racingcar.domain.strategy.MockRandomMovingStrategy.MOVABLE_RANDOM_MOVE_STRATEGY;

public class RacingCarFixture {

    public static final Name PARTICIPANT_NAME = new Name("ahn");

    public static final RacingCar MOVABLE_RACING_CAR =
            new RacingCar(PARTICIPANT_NAME, MOVABLE_RANDOM_MOVE_STRATEGY);

    public static final RacingCar IMMOVABLE_RACING_CAR =
            new RacingCar(PARTICIPANT_NAME, MockRandomMovingStrategy.IMMOVABLE_RANDOM_MOVE_STRATEGY);


    public static final RacingCars RACING_CARS =
            RacingCars.from(Collections.unmodifiableList(Arrays.asList(MOVABLE_RACING_CAR, IMMOVABLE_RACING_CAR)));

    public static RacingCar 특정_위치의_경주용_자동차를_생성(String name, int value) {
        return new RacingCar(new Name(name), Position.from(value), MOVABLE_RANDOM_MOVE_STRATEGY);
    }
}
