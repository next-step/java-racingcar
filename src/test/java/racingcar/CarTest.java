package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("숫자가 4 이상이 나오면 자동차는 움직인다")
    void isMove(int number, boolean expected) {
        Car car = new Car(new RandomForTest(number));
        Assertions.assertThat(car.isMove()).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차가 움직이면 위치가 1 증가한다")
    void move() {
        Car movingCar = new CarForTest(true);
        movingCar.move();
        Assertions.assertThat(movingCar.getPosition()).isEqualTo(1);

        Car stoppedCar = new CarForTest(false);
        stoppedCar.move();
        Assertions.assertThat(stoppedCar.getPosition()).isEqualTo(0);
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

    private static class CarForTest extends Car {

        private final boolean isMove;

        public CarForTest(boolean isMove) {
            super(new Random());
            this.isMove = isMove;
        }

        @Override
        boolean isMove() {
            return isMove;
        }
    }
}
