package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    @DisplayName("자동차 경주 실행 확인")
    void start() {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        racingCar.setCar(3);
        racingCar.setTrial(4);

        // then
        racingCar.start();
    }

}