package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차가 전진하면 자동차의 위치가 1씩 증가한다")
    public void moveCarsChangePositionByRandom() {
        Car car = new Car("수형");

        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(true);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
