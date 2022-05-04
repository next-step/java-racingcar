package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private static final int START_MOVE_VALUE = 0;

    @DisplayName("최대 이동 거리 유무 확인")
    @Test
    void isMaxPosition() {
        int maxPosition = 3;
        assertThat(new Car("car1", 3).isWinner(maxPosition)).isTrue();
        assertThat(new Car("car1", 2).isWinner(maxPosition)).isFalse();
    }

    @DisplayName("최대 이동 거리 확인")
    @Test
    void maxPosition() {
        Car car1 = new Car("car1", 3);
        assertThat(car1.maxPosition(3)).isEqualTo(3);
    }

    @DisplayName("car")
    @Test
    void move() {
        Car car1 = new Car("car1", START_MOVE_VALUE);
        car1.move(1);
        assertThat(car1.getPosition()).isEqualTo(START_MOVE_VALUE + 1);
    }
}