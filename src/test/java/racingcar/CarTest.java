package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.car.Car;
import racingcar.car.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int ZERO = 0;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("자동차 항상 움직이는 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void successMovingStrategy(int movingCount) {
        for(int i = 0; i < movingCount; i++) {
            car.move(() -> true);
        }
        assertThat(car.getPosition()).isEqualTo(movingCount);
    }

    @DisplayName("자동차 항상 움직이지 않는 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void failMovingStrategy(int movingCount) {
        for(int i = 0; i < movingCount; i++) {
            car.move(() -> false);
        }
        assertThat(car.getPosition()).isEqualTo(ZERO);
    }

    @DisplayName("자동차의 움직임이 랜덤한 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void randomMovingStrategy(int movingCount) {
        for(int i = 0; i < movingCount; i++) {
            car.move(new RandomMovingStrategy());
        }
        assertThat(car.getPosition()).isBetween(ZERO, movingCount);
    }
}
