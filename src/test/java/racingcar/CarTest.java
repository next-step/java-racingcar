package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0", "3:0", "4:1"}, delimiter = ':')
    @DisplayName("숫자가 4 이상이 나오면 자동차는 움직일 수 있다")
    void moveTest(int number, int realPosition) {
        Car car = new Car();
        car.move(new RandomValueForTest(number));
        int currentPosition = car.getPosition();
        Assertions.assertThat(currentPosition).isEqualTo(realPosition);
    }

    private static class RandomValueForTest extends Random {
        private final int returnNumber;

        RandomValueForTest(int returnNumber) {
            this.returnNumber = returnNumber;
        }

        @Override
        public int nextInt(int bound) {
            return returnNumber;
        }
    }
}
