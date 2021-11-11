package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.vo.CarState;

import static org.assertj.core.api.Assertions.assertThat;
import static racinggame.fixture.CarFixture.CAR_NAME1;

class CarStateTest {
    private static final int INIT_POSITION = 0;

    private CarState carState;

    @BeforeEach
    void setUp() {
        carState = new CarState(CAR_NAME1, INIT_POSITION);
    }

    @DisplayName("자동차 이동시 변화")
    @Test
    void move() {
        carState.move();

        assertThat(carState.currentPosition()).isGreaterThan(INIT_POSITION);
    }

}