package racingcar.util;

import org.junit.jupiter.api.Disabled;

import static racingcar.model.Car.RUNNING_CONDITION;
import static racingcar.util.RandomGenerator.LIMIT_BOUND;

@Disabled
public class MockGenerator implements NumberGenerator {

    private int mock;

    public static MockGenerator generate(CarState state) {
        return new MockGenerator(state.power);
    }

    private MockGenerator(int mock) {
        validatePower(mock);
        this.mock = mock;
    }

    private void validatePower(int power) {
        if (power < 0 || power >= LIMIT_BOUND) {
            throw new IllegalArgumentException(0 + "이상" + LIMIT_BOUND + "미만의 값만 가능합니다.");
        }
    }

    @Override
    public int getNumber() {
        return mock;
    }

    public enum CarState {
        RUN(RUNNING_CONDITION),
        MAINTAIN(RUNNING_CONDITION - 1);

        private final int power;

        CarState(int power) {
            this.power = power;
        }
    }
}
