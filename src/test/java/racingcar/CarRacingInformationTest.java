package racingcar;

import org.junit.jupiter.api.BeforeEach;
import racingcar.controller.RacingGameController;
import racingcar.model.CarRacingInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarRacingInformationTest {

    List<String> carNameList;

    @BeforeEach
    void setUp() {
        carNameList
                = Arrays.asList(new String[]{"one", "two", "three", "four"});
    }

    @Test
    @DisplayName("CarRacingInformaiton 객체 생성")
    public void inputNumberOfCar() {
        assertThatCode(() ->
                new CarRacingInformation(carNameList,5))
                .doesNotThrowAnyException();
    }


    @Test
    @DisplayName("입력값(자동차 수,경기 횟수)이 0 이하인 경우 확인")
    public void isZeroOrLess() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarRacingInformation(carNameList,-1);
        });
    }

    @Test
    @DisplayName("경주 시도횟수가 1씩 줄어드는지")
    public void checkCarRacingCount() {

        CarRacingInformation carRacingInformation
                = new CarRacingInformation(carNameList,5);
        carRacingInformation.minusCarRacingCount();

        assertEquals(4,carRacingInformation.getCarRacingCount());
    }



    @Test
    @DisplayName("남아있는 시도횟수가 0 이하인 경우 시도횟수 체크")
    public void checkCarRacingCountLessThanZeroAndLess() {
        CarRacingInformation carRacingInformation
                = new CarRacingInformation(carNameList,1);
        carRacingInformation.minusCarRacingCount();
        assertEquals(false,carRacingInformation.checkCarRacingCount());
    }

    @Test
    @DisplayName("이름이 중복되는 경우 예외를 발생시킨다.")
    public void checkDuplication() {
        List<String> duplicateCarNameList = Arrays.asList(new String[]{"one", "two", "one"});
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CarRacingInformation(duplicateCarNameList,5);
        });
    }


}
