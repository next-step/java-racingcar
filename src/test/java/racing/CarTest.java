package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("자동차는 이름과 위치를 가지고 생성된다.")
    @Test
    void createCarTest() {
        Car car = new Car("name", 0);

        assertThat(car.getName()).isEqualTo("name");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차의 이름은 5자를 넘을 수 없다.")
    @Test
    void carNameTest() {
        assertThatThrownBy(() -> new Car("여섯글자이름", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자를 넘을 수 없습니다.");
    }

    @DisplayName("자동차의 이름은 1자 이상이여야 한다.")
    @Test
    void carNameBlankTest() {
        assertThatThrownBy(() -> new Car("", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 1자 이상이여야 합니다.");
    }

    @DisplayName("4이상의 숫자를 받았을 경우 자동차는 움직인다.")
    @Test
    void carMoveTest() {
        Car car = new Car("name", 0);
        car.tryMove(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}