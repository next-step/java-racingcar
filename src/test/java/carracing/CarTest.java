package carracing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("전진하는 조건은 0에서 9사이")
    void drivingCondition() {
        assertThatThrownBy(() -> {
            Car car = new Car();
            car.driving(10);
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("전진 테스트")
    void advance() {
        Car racingCar = new Car();
        Assertions.assertThat(racingCar.driving(4)).isTrue();
    }

    @Test
    @DisplayName("멈춤 테스트")
    void stoppage() {
        Car notRacingCar = new Car();
        notRacingCar.driving(4);
        Assertions.assertThat(notRacingCar.driving(3)).isFalse();
    }

}
