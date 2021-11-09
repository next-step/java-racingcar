package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.collection.CarName;
import racingcar.strategy.TestMoveStrategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    public final static String TEST_CAR_NAME = "test";

    @Test
    @DisplayName("move 메소드는 자동차를 이동시키고 현재 위치를 반환한다")
    public void 테스트_Car_move() {
        Car car = new Car(new CarName(TEST_CAR_NAME), new TestMoveStrategy());
        int iterationCount = 5;

        for (int i = 1; i < iterationCount; i++) {
            assertThat(car.move().getPosition()).isEqualTo(i);
        }
    }
}