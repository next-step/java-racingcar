package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private Car car;

    @DisplayName("각 자동차에 이름을 부여할 수 있다. ")
    @Test
    void playerCar() {
        car = new Car("chloe");
        assertThat(car.getName()).isEqualTo("chloe");
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void throwIllegalArgumentException() {
        assertThatThrownBy(() -> {
            car = new Car("bigRigs");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
