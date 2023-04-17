package step3;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 0giri
 * @since : 2023/04/17
 */
public class CarActionDeciderTest {

    @Test
    void 주어진_숫자가_4이상이면_전진() {
        Consumer<Car> action = CarActionDecider.action(5);
        Car car = new Car();
        action.accept(car);
        assertThat(car.location()).isEqualTo(5);
    }

    @Test
    void 주어진_숫자가_4미만이면_멈춤() {
        Consumer<Car> action = CarActionDecider.action(3);
        Car car = new Car();
        action.accept(car);
        assertThat(car.location()).isEqualTo(0);
    }

    @Test
    void 주어진_숫자가_0미만이면_예외() {
        assertThatThrownBy(() -> CarActionDecider.action(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
