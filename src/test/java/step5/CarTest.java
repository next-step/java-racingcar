package step5;

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

    @DisplayName("차량 움직임 테스트")
    @Test
    void move() {
        final Car car = Car.withName("test");
        final Moving strategy = new RandomMoving() {
            @Override
            public boolean movable() {
                return true;
            }
        };

        car.move(strategy);

        final CarMovementResult result = car.movementResult();
        assertThat(result.moveCount()).isEqualTo(1);
    }

}
