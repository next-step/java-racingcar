package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다")
    public void race_ValidCarName() {
        Car car = new Car("pobi");
        assertThat(car.toDto().getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    public void race_InvalidCarName() {
        assertThatThrownBy(() -> new Car("longPobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid Car Name: longPobi");
    }

    @Test
    @DisplayName("4 이상일 때 이동한다")
    public void carMove_WhenNumberMoreThanEqualMinimumNumberToMove() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.toDto().getPosition()).isOne();
    }

    @Test
    @DisplayName("3 미만일 때 이동하지 않는다")
    public void carMove_WhenNumberLessThanMinimumNumberToMove() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.toDto().getPosition()).isZero();
    }
}
