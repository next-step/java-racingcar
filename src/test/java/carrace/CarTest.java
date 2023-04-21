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
    void getRecentRoundPosition_test() {
        assertThat(car.getRecentRoundPosition()).isEqualTo(0);

        car.setNewRoundPosition(5);
        assertThat(car.getRecentRoundPosition()).isEqualTo(5);
    }

    @Test
    void getPositionAtRound_test() {
        car.setNewRoundPosition(5);
        assertThat(car.getPositionAtRound(0)).isEqualTo(5);
    }

    @Test
    void getPosition_indexOutOfBound_Test() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    car.getPositionAtRound(10);
                });
    }
}