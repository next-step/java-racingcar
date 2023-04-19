package carrace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @Test
    void carPosition_test() {
        assertThat(car.getRecentRoundPosition()).isEqualTo(0);

        car.setNewRoundPosition(5);
        assertThat(car.getRecentRoundPosition()).isEqualTo(5);

        assertThat(car.getPositionAtRound(0)).isEqualTo(5);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    car.getPositionAtRound(10);
                });
    }
}