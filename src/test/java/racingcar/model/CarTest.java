package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;
    private final int DEFAULT_DISTANCE = 0;

    @BeforeEach
    void setUp() {
        car = new Car(DEFAULT_DISTANCE);
    }

    @DisplayName("자동차 이동을 성공한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void move(int distance) {
        // when
        for (int i = 0; i < distance; i++) {
            car.move();
        }

        // then
        assertThat(car.getDistance()).isEqualTo(distance);
    }
}