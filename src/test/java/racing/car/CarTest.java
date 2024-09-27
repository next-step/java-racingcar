package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.car.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("move 메서드는 3 이상인 경우 position은 증가하지 않는다.")
    void 앞으로_이동_4이하() {
        Car car = new Car();
        car.move(3);

        assertThat(car).extracting("position").isEqualTo(0);

    }

    @Test
    @DisplayName("move 메서드는 4 이상인 경우 position이 1증가 된다.")
    void 앞으로_이동_4이상() {
        Car car = new Car();
        car.move(6);

        assertThat(car).extracting("position").isEqualTo(1);
    }

    @Test
    @DisplayName("move 메서드가 0 ~ 9 사이의 숫자가 아닌 경우 RuntimeException이 발생 된다.")
    void 숫자가_0에서_9사이가_아닌_경우() {
        Car car = new Car();

        assertThatThrownBy(
                () -> car.move(10))
                .isInstanceOf(RuntimeException.class);

    }
}
