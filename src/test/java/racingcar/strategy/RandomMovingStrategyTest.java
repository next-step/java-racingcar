package racingcar.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 움직임 전략 테스트")
class RandomMovingStrategyTest {

    @DisplayName("랜덤 값의 결과가 0이상 4미만 이라면 움직여선 안된다")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void moveByZero(int randInt) {
        Random mock = new MockRandom(randInt);
        MovingStrategy strategy = new RandomMovingStrategy(mock);

        int movement = strategy.movement();
        assertThat(movement).isEqualTo(0);
    }

    @DisplayName("랜덤 값의 결과가 4이상 9이하라면 1만큼 움직여야 한다")
    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void moveByOne(int randInt) {
        Random mock = new MockRandom(randInt);
        MovingStrategy strategy = new RandomMovingStrategy(mock);

        int movement = strategy.movement();
        assertThat(movement).isEqualTo(1);
    }

    class MockRandom extends Random {
        private final int value;

        public MockRandom(int value) {
            this.value = value;
        }

        @Override
        public int nextInt(int totalBound) {
            return value;
        }
    }
}