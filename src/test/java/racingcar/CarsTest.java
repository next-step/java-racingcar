package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    void constructor() {
        List<Car> cars = new ArrayList<Car>() {
            {
                add(new Car("a"));
                add(new Car("b"));
            }
        };
        Cars c = new Cars(cars);
        assertThat(c).isEqualTo(new Cars(cars));
    }

    @Test
    void addCar() {
        Cars c = new Cars();
        c.add(new Car("A"));
        assertThat(c).hasSize(1);
    }

    @Test
    void removeCarShouldThrowException() {
        Cars c = new Cars();
        assertThatThrownBy(() -> c.remove(0)).isInstanceOf(IllegalCallerException.class);
    }
}
