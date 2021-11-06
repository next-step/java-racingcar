package racingStep3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class carMethodTest {

    @Test
    @DisplayName("랜덤 값이 4이상 일경우 앞으로 한칸 이동!!!")
    public void forwardTest() {
        RacingCar car = new RacingCar();
        car.moveOrNot(5);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4미만 일경우 자동차 이동 하지 않음!!")
    public void stopTest() {
        RacingCar car = new RacingCar();
        car.moveOrNot(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
