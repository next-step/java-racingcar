package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.CarRacingInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarRacingInformationTest {


    @Test
    @DisplayName("CarRacingInformaiton 객체 생성")
    public void inputNumberOfCar() {
        int[] intarr = {3,5};
        assertThatCode(() -> new CarRacingInformation(intarr[0],intarr[1]))
                .doesNotThrowAnyException();
    }


    @Test
    @DisplayName("입력값(자동차 수)이 0 이하인 경우 확인")
    public void isZeroOrLess() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarRacingInformation(0,-1);
        });
    }

    @Test
    @DisplayName("경주 시도횟수가 1씩 줄어드는지")
    public void checkCarRacingCount() {
        CarRacingInformation carRacingInformation
                = new CarRacingInformation(3,5);
        carRacingInformation.minusCarRacingCount();

        assertEquals(4,carRacingInformation.getCarRacingCount());
    }


    @Test
    @DisplayName("남아있는 시도횟수가 0 이하인 경우 시도횟수 체크")
    public void checkCarRacingCountLessThanZeroAndLess(){
        CarRacingInformation carRacingInformation
                = new CarRacingInformation(3,1);
        carRacingInformation.minusCarRacingCount();
        assertEquals(false,carRacingInformation.checkCarRacingCount());
    }

}
