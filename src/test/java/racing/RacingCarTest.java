package racing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 생성")
    void create() {
        RacingCar actual = new RacingCar();
        assertThat(actual).isNotNull();
    }

    @Test
    @DisplayName(("자동차 전진 테스트"))
    void ongoing() {
        RacingCar car = new RacingCar();
        float REPEAT_NUMBER = 10000;
        for (int i = 0; i < REPEAT_NUMBER; i++) {
            car.ongoing();
        }

        float actual = car.getNumberOfOngoing() / REPEAT_NUMBER;
        System.out.println("actual = " + actual);
        assertThat(actual >= 0.55 && actual <= 0.65).isTrue();
    }
}

