package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Car;
import step4.domain.Moving;
import step4.domain.RandomMoving;
import step4.view.result.CarMovementResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {

    @DisplayName("자동차는 5자 초과의 이름을 가질 수 없다.")
    @Test
    void constructor() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Car.withName("다섯글자다다"));
    }

    @DisplayName("차량을 움직일 경우, 움직인 거리가 증가한다.")
    @Test
    void move() {
        final Car car = Car.withName("test");

        car.move(() -> true);

        final CarMovementResult result = car.movementResult();
        assertThat(result.moveCount()).isEqualTo(1);
    }

    @DisplayName("차량을 움직이지 않을 경우, 움직인 거리가 그대로다.")
    @Test
    void notMove() {
        final Car car = Car.withName("test");

        car.move(() -> false);

        final CarMovementResult result = car.movementResult();
        assertThat(result.moveCount()).isEqualTo(0);
    }

}
