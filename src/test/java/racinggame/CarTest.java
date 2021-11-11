package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.fixture.CarFixture.CAR1;

class CarTest {
    private static final int INIT_POSITION = 0;

    private Car car;

    @BeforeEach
    void setUp() {
        car = CAR1;
    }

    @DisplayName("자동차 이동시 변화")
    @Test
    void move() {
        car.move(true);

        assertThat(car.currentState()
                .currentPosition())
                .isGreaterThan(INIT_POSITION);
    }
}