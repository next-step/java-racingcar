package carracing;

import carracing.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("자동차 이동 테스트")
    void moveCarTest() {
        final int MOVE_DISTANCE = 1;
        Car car = new Car("kim");
        car.move();
        assertThat(car.getLocation()).isEqualTo(MOVE_DISTANCE);
    }

    @Test
    @DisplayName("자동차이름이 5글자가 초과할경우 익셉션 테스트")
    void checkNameNumberOverFive() {
        assertThatThrownBy(() -> new Car("kimwoo"))
                .isInstanceOf(RuntimeException.class);
    }
}
