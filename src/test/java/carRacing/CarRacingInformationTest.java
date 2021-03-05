package carRacing;

import calculator.Validator;
import carRacing.model.CarRacingInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarRacingInformationTest {


    @Test
    @DisplayName("CarRacingInformaiton 객체 생성")
    public void inputNumberOfCar() {
        int[] intarr = {3,5};
        assertThatCode(() -> new CarRacingInformation(intarr[0],intarr[1]))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1","0"})
    @DisplayName("입력값(자동차 수, 경주 시도 횟수)이 0 이하인 경우 확인")
    public void isZeroOrLess() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarRacingInformation(0,-1);
        });
    }

    @DisplayName("경주 시도횟수가 1씩 줄어드는지")
    public void checkCarRacingCount() {

    }

    //남아있는 시도횟수가 0이하일만 실행인지 확인
    @DisplayName("남아있는 시도횟수가 0 이하인 경우 게임이 진행되는지 확인")
    public void isPlayMoreThanInputCarRacingCount() {

    }

}
