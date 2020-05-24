package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱카 클래스 테스트")
class RacingCarTest {

    @Test
    @DisplayName("자동차 대수 테스트")
    void racingCarSizeTest() {
        int carCount = 4;
        RacingCar racingCar = new RacingCar(4);
        assertThat(carCount).isEqualTo(racingCar.getCarList().size());
    }
}