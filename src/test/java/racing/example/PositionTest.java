package racing.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void create() {
        assertThat(new Position(1)).isEqualTo(new Position("1"));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최대_이동거리_유무() {
        int maxPosition = 3;
        assertThat(new Car("ocean", 3).isWinner(maxPosition)).isTrue();
        assertThat(new Car("ocean", 2).isWinner(maxPosition)).isFalse();
    }

    @Test
    void 최대_이동거리_구하기() {
        Car car = new Car("ocean", 3);
        assertThat(car.maxPosition(2)).isEqualTo(3);
        assertThat(car.maxPosition(4)).isEqualTo(4);
    }
}
