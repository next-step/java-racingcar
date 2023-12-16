package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("자동차가 정지한다")
    @Test
    public void 자동차가_정지한다() {
        Car car = new Car(1,0);
        assertThat(car.getDistance()).isEqualTo(0);
    }
    @DisplayName("자동차가 전진한다")
    @Test
    public void 자동차가_전진한다() {
        Car car = new Car(1,0);
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
