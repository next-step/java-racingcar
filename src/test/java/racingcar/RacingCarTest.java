package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class RacingCarTest {
    RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("0보다 크고 9보다 작아야합니다.")
    public void vaildateCountTest(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()-> racingCar.move(-1))
                .withMessage("0보다 크고 9보다 작아야합니다.");
    }

    @Test
    @DisplayName("4이상 일 경우  이동")
    public void moveTest(){
        racingCar.move(4);
        assertThat(racingCar.getPoint()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만 일 경우 정지")
    public void stopTest(){
        racingCar.move(3);
        assertThat(racingCar.getPoint()).isEqualTo(0);
    }
}