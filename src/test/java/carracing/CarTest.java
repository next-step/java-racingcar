package carracing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("전진하는 조건은 0에서 9사이 4이상")
    void drivingCondition() {
        Car car = new Car();
        for (int i = 0; i < 10; i++) {
            car.driving(i);
        }
        Assertions.assertThat(car.getDrivingHistory()).isEqualTo(6);
    }

    @Test
    @DisplayName("전진 테스트")
    void advance() {
        Car racingCar = new Car();
        racingCar.driving(4);

        Assertions.assertThat(racingCar.getDrivingHistory()).isEqualTo(2);
    }

    @Test
    @DisplayName("멈춤 테스트")
    void stoppage() {
        Car notRacingCar = new Car();
        notRacingCar.driving(3);

        Assertions.assertThat(notRacingCar.getDrivingHistory()).isEqualTo(0);
    }

}
