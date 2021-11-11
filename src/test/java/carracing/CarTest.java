package carracing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("전진 또는 멈춤 테스트")
    void driving() {

        // 전진 차
        Car racingCar = new Car();
        racingCar.driving(4);

        Assertions.assertThat(racingCar.getDrivingHistory()).isEqualTo(1);

        // 멈춤 차
        Car notRacingCar = new Car();
        notRacingCar.driving(3);

        Assertions.assertThat(notRacingCar.getDrivingHistory()).isEqualTo(0);
    }

}
