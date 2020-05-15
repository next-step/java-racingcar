package racingcar.moving;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovingStrategyTest {

    @DisplayName("기준값 이상의 값이면 true 를 반환, 기준값 미만이면 false 를 반환")
    @ParameterizedTest
    @MethodSource(value = "fixedRandomCase")
    void isMovable(final Random fixedRandom, final boolean expected) {
        assertThat(new RandomMovingStrategy(fixedRandom).isMovable()).isEqualTo(expected);
    }

    private static Stream<Arguments> fixedRandomCase() {
        return Stream.of(
                Arguments.of(TestRandom.of(RandomMovingStrategy.BASE_LINE_NUM - 1), false),
                Arguments.of(TestRandom.of(RandomMovingStrategy.BASE_LINE_NUM), true),
                Arguments.of(TestRandom.of(RandomMovingStrategy.BASE_LINE_NUM + 1), true)
        );
    }

    static class TestRandom extends Random {

        private final int fixedValue;

        private TestRandom(final int fixedValue) {
            this.fixedValue = fixedValue;
        }

        private static TestRandom of(final int fixedValue) {
            return new TestRandom(fixedValue);
        }

        @Override
        public int nextInt(int bound) {
            return fixedValue;
        }
    }
}
