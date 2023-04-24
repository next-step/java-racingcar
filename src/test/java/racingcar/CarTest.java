package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {
    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다")
    public void race_ValidCarName() {
        Car car = new Car("pobi", new AlwaysMoveStrategy());
        assertThat(car.toDto().getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    public void race_InvalidCarName() {
        assertThatThrownBy(() -> new Car("longPobi", new AlwaysMoveStrategy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid Car Name: longPobi");
    }
}
