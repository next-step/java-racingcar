package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.result.CarMovementResult;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("차량을 움직일 경우, 움직인 거리가 증가한다.")
    @Test
    void move() {
        final Car car = Car.withName("test");

        final CarMovementResult result = car.move(() -> true);

        assertThat(result.moveCount()).isEqualTo(1);
    }

    @DisplayName("차량을 움직이지 않을 경우, 움직인 거리가 그대로다.")
    @Test
    void notMove() {
        final Car car = Car.withName("test");

        final CarMovementResult result = car.move(() -> false);

        assertThat(result.moveCount()).isEqualTo(0);
    }

}
