package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingGameTest {

    @Test
    @DisplayName("자동차들이 최대 tryCount만큼 움직여야 한다")
    void process() {
        List<Car> carsForTest = List.of(
                new Car(),
                new Car()
        );
        int tryCount = 3;
        new RacingGame(carsForTest, tryCount, new ResultView(), new CarsMoverForTest()).process();
        Assertions.assertThat(carsForTest).allMatch(car -> car.getPosition() == tryCount);
    }

    private static class CarsMoverForTest extends CarsMover {

        @Override
        public void moveCars(List<Car> cars) {
            for (Car car : cars) {
                car.move(1);
            }
        }
    }
}
