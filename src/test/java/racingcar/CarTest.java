package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @Test
    @DisplayName("랜덤 값이 4 미만일 경우, 위치가 변하지 않아야 한다.")
    void 랜덤값_4미만_멈춤() {
        car = new Car("ming", () -> false);
        car.run();
        assertThat(car).isEqualTo(new Car("ming", 0, () -> false));
    }

    @Test
    @DisplayName("랜덤 값이 4 이상일 경우, 위치가 변해야 한다.")
    void 랜덤값_4이상_전진() {
        car = new Car("ming", () -> true);
        car.run();
        assertThat(car).isNotEqualTo(new Car("ming", 0, () -> false));
        assertThat(car).isEqualTo(new Car("ming", 1, () -> false));
    }

}
