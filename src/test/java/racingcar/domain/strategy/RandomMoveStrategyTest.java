package racingcar.domain.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

class RandomMoveStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("숫자가 4 이상이 나오면 자동차는 움직일 수 있다")
    void moveTest(int number, boolean expectedIsMovable) {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(new RandomForTest(number));
        Assertions.assertThat(randomMoveStrategy.isMovable()).isEqualTo(expectedIsMovable);
    }

    public static class RandomForTest extends Random {

        private final int returnNumber;

        RandomForTest(int returnNumber) {
            this.returnNumber = returnNumber;
        }

        @Override
        public int nextInt(int bound) {
            return returnNumber;
        }
    }
}
