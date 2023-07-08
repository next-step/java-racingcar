package racingcar.car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("a");
    }

    @Test
    @DisplayName("한 칸 이동한다.")
    void move_moveOneStep() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("position 값이 동일하면 참을 반환한다.")
    void matchPosition_givenEqualValue_returnTrue() {
        assertThat(car.matchPosition(0)).isTrue();
    }

    @Test
    @DisplayName("두 Car 객체의 position 을 비교할 때, 더 큰 position 값을 반환한다.")
    void getMaxPosition_givenOtherPosition_returnBiggerPosition() {
        assertThat(car.getMaxPosition(1)).isEqualTo(1);
    }
}

