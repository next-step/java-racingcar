package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {
    @Test
    void 처음_시작은_1이다() {
        CarPosition carPosition = new CarPosition();
        assertThat(carPosition).isEqualTo(new CarPosition(1));
    }

    @Test
    void 한번_이동하면_입력된_값을_이동한다() {
        CarPosition carPosition = new CarPosition();
        carPosition.move();
        assertThat(carPosition).isEqualTo(new CarPosition(2));
    }
}
