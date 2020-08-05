package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step03.exception.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/*
    com.hskim.nextstep.step03 - RacingCarSimulator class 테스트
 */
public class RacingCarSimulatorTest {

    private RacingCarSimulator racingCarSimulator;

    @BeforeEach
    void setUp() {

        racingCarSimulator = new RacingCarSimulator();
    }

    /*
        setRacingCarList로 만들어진 racingCarList의 크기가 getRacingCarList로 가져온 크기와 같은지 검증
     */
    @DisplayName("setRacingCarList() & getRacingCarList() 메소드 정상작동 검증")
    @ParameterizedTest
    @ValueSource(strings = {"kim,lee,park", "choi,jung", "hyun,yuk,kwag,han,won", "jang"})
    void racingCarListGetterSetterSuccessTest(String carName) {

        racingCarSimulator.setRacingCarList(carName);
        assertThat(racingCarSimulator.getRacingCarList().size()).isEqualTo(getCarNum(carName));
    }

    /*
        자동차 이름의 길이가 @{RancingCarSimulator.CAR_NAME_LIMIT}를 초과하면 예외발생
     */
    @DisplayName("setRacingCarList() 메소드 예외 상황 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"samuel,kim,lee", "michael,su", "ray,nick,jordan"})
    void setRacingCarListExceptionTest(String carName) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCarSimulator.setRacingCarList(carName))
                .withMessage(ExceptionMessage.EXCEED_CAR_NAME_LENGTH.getExceptionMessage());
    }

    private int getCarNum(String carName) {

        return carName.split(",").length;
    }
}
