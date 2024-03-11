package racingcar.fixture;

import racingcar.DrivingStrategy;

public class DrivingStrategyFixture {

    public static final DrivingStrategy ALWAYS_MOVE = () -> true;
    public static final DrivingStrategy NEVER_MOVE = () -> false;
}
