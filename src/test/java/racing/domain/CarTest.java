package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {
    private Car car;

    @BeforeEach
    void 차를_생성() {
        car = new Car();
    }

    @Test
    void 차가_전진() {
        assertThat(car.moveForwardOrStop(() -> true)).isEqualTo(1);
    }

    @Test
    void 차가_정지() {
        assertThat(car.moveForwardOrStop(() -> false)).isEqualTo(0);
    }

    @Test
    void 차의_누적거리() {
        assertAll(
                () -> car.accumulateOneRound(() -> true),
                () -> assertThat(car.getDistance()).isEqualTo(1),
                () -> car.accumulateOneRound(() -> false),
                () -> assertThat(car.getDistance()).isEqualTo(1),
                () -> car.accumulateOneRound(() -> true),
                () -> assertThat(car.getDistance()).isEqualTo(2),
                () -> car.accumulateOneRound(() -> true),
                () -> assertThat(car.getDistance()).isEqualTo(3),
                () -> car.accumulateOneRound(() -> false),
                () -> assertThat(car.getDistance()).isEqualTo(3)
        );
    }
}
