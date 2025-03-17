package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

class DiceTest {
    static final Dice luckyDice = new Dice(new DiceTest.MockRandom(Car.MOVE_THRESHOLD + 1));

    @ParameterizedTest
    @ValueSource(ints = {-10000, 0, 2, 9, 10, 123, 2324424})
    @DisplayName("주사위는 10으로 나눈 나머지를 반환한다.")
    void rollTest(int mockRandomValue) {
        // given
        var dice = new Dice(new MockRandom(mockRandomValue));

        // when
        int result = dice.roll();

        // then
        Assertions.assertThat(result).isEqualTo(mockRandomValue % 10);
    }

    static class MockRandom extends Random {
        private final int returnValue;

        public MockRandom(int returnValue) {
            this.returnValue = returnValue;
        }

        @Override
        public int nextInt() {
            return returnValue;
        }
    }
}
