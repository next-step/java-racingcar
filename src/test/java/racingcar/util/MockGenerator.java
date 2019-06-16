package racingcar.util;

import org.junit.jupiter.api.Disabled;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racingcar.model.Car.RUNNING_CONDITION;
import static racingcar.util.RandomGenerator.LIMIT_BOUND;

@Disabled
public class MockGenerator implements NumberGenerator {

    private int index;
    private List<Integer> mocks;

    public static MockGenerator generate(int... mocks) {
        List<Integer> mockList = IntStream.of(mocks).boxed().collect(Collectors.toList());
        return new MockGenerator(mockList);
    }

    public static MockGenerator generate(CarState... states) {
        List<Integer> collect = Arrays.stream(states)
                .mapToInt(value -> value.power).boxed().collect(Collectors.toList());
        return new MockGenerator(collect);
    }

    private MockGenerator(List<Integer> mocks) {
        mocks.stream().forEach(value -> validatePower(value));
        this.mocks = mocks;
    }

    private void validatePower(int power) {
        if (power < 0 || power >= LIMIT_BOUND) {
            throw new IllegalArgumentException("STATE 입력값이 잘못되었습니다. 입력한 값: " + power);
        }
    }

    @Override
    public int getNumber() {
        return mocks.get(index++);
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
