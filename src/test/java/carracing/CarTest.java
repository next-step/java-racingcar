package carracing;

import carracing.domain.Car;
import carracing.exception.CarNameFormatException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("전진하는 조건은 0에서 9사이")
    void drivingCondition() {
        assertThatThrownBy(() -> {
            Car car = new Car("car");
            car.driving(10);
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("전진 테스트")
    void advance() throws CarNameFormatException {
        Car racingCar = new Car("car");
        Assertions.assertThat(racingCar.driving(4)).isTrue();
    }

    @Test
    @DisplayName("멈춤 테스트")
    void stoppage() throws CarNameFormatException {
        Car notRacingCar = new Car("car");
        notRacingCar.driving(4);
        Assertions.assertThat(notRacingCar.driving(3)).isFalse();
    }

}
