package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private List<Car> cars;
    private Racing racing;

    @BeforeEach
    void set() {
        cars = new ArrayList<>();
        cars.add(new Car("chloe"));
        cars.add(new Car("tt"));
        racing = new Racing(cars);
    }
    @DisplayName("각 자동차에 이름을 부여할 수 있다. ")
    @Test
    void playerCar() {
        assertThat(racing.getCarNames()).containsExactly("chloe", "tt");
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void throwIllegalArgumentException() {
        assertThatThrownBy(() -> {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("chloeJ"));
            cars.add(new Car("tt"));
            Racing racing = new Racing(cars);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
