package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

class RacingCarServiceTest {

    @Test
    @DisplayName("자동차 경주가 정상적으로 진행되어야 한다.")
    void process() {
        List<Car> carsForTest = List.of(
                new CarForTest(true),
                new CarForTest(true),
                new CarForTest(true)
        );
        int tryCount = 3;
        new RacingCarService(carsForTest, tryCount).process();
        Assertions.assertThat(carsForTest).allMatch(car -> car.getPosition() == tryCount);
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
