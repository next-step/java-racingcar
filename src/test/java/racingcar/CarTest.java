package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("숫자가 4 이상이 나오면 자동차는 움직일 수 있다")
    void isMoveTest(int number, boolean isCarMove) {
        Car car = new Car();
        boolean actual = car.isMove(new RandomForTest(number));
        Assertions.assertThat(actual).isEqualTo(isCarMove);
    }

    private static class RandomForTest extends Random {

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
