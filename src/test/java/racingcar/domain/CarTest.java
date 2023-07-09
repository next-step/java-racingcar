package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("움직일 수 있는 경우 전진한다")
    public void 움직일_수_있는_경우_전진한다() throws Exception {
        Car car = new Car("chan");

        car.progress(() -> true);

        assertThat(car.isSameDistance(1)).isTrue();
    }

    @Test
    @DisplayName("더 멀리간 차를 반환한다")
    public void 더_멀리간_차를_반환한다() {
        Car car = new Car("chan", 1);
        Car furtherCar = new Car("ipt", 2);

        Car result = car.returnFurtherMovedCar(furtherCar);

        assertThat(result).isEqualTo(furtherCar);
    }
}
