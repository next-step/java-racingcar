package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @DisplayName("차량 전진 테스트")
    @Test
    void 차량_전진_테스트() {
        RacingCar racingCar = new RacingCar();
        racingCar.goForward();
        assertThat(racingCar.showDrivenDistance()).isEqualTo(1);
    }

    @Test
    void 랜덤_값_생성() {

    }

    @Test
    void 랜덤_조건_판단() {

    }

   @Test
    void 차량_상태_출력() {

    }

}
