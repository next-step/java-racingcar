package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {


    @Test
    @DisplayName("입력받은 수만큼 자동차 생성")
    void 자동차_생성() {
        RacingCar racingCar = new RacingCar();

        assertThat(racingCar.createCars(5)).hasSize(5);
    }

}
