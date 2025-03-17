package racingcar.domain.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;

import java.util.Random;

class RandomMoveStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"2:0", "3:0", "4:1", "5:1"}, delimiter = ':')
    @DisplayName("숫자가 4 이상이 나오면 자동차는 움직일 수 있다")
    void moveTest(int number, int expectedPosition) {
        Car car = Car.of("pobi");
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(new RandomForTest(number));
        car.move(randomMoveStrategy);
        int actualPosition = car.getPosition();
        Assertions.assertThat(actualPosition).isEqualTo(expectedPosition);
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
