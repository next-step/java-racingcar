package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @Test
    @DisplayName("랜덤 값이 4 미만일 경우, 위치가 변하지 않아야 한다.")
    void 랜덤값_4미만_멈춤() {
        MoveStrategy moveStrategy = () -> false;
        car = new Car("ming", moveStrategy);
        int prePosition = car.getPosition();
        car.run();
        assertThat(car.getPosition()).isEqualTo(prePosition);
    }

    @Test
    @DisplayName("랜덤 값이 4 이상일 경우, 위치가 변해야 한다.")
    void 랜덤값_4이상_전진() {
        MoveStrategy moveStrategy = () -> true;
        car = new Car("ming", moveStrategy);
        int prePosition = car.getPosition();
        car.run();
        assertThat(car.getPosition()).isNotEqualTo(prePosition);
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
