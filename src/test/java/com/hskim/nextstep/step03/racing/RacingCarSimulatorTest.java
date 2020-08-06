package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step02.utils.StringUtils;
import com.hskim.nextstep.step03.exception.ExceptionMessage;
import com.hskim.nextstep.step03.model.RacingCar;
import com.hskim.nextstep.step03.utils.ValidationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

        List<String> carNameList = StringUtils.getParsedStringList(carName, RacingCarSimulator.CAR_NAME_DELIMITER);
        ValidationUtils.validateStringLengthLimitWithList(carNameList,
                RacingCar.CAR_NAME_LIMIT, ExceptionMessage.EXCEED_CAR_NAME_LENGTH);
        racingCarSimulator.setRacingCarList(carNameList);
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
                .isThrownBy(() -> {
                    List<String> carNameList =
                            StringUtils.getParsedStringList(carName, RacingCarSimulator.CAR_NAME_DELIMITER);
                    ValidationUtils.validateStringLengthLimitWithList(carNameList,
                            RacingCar.CAR_NAME_LIMIT, ExceptionMessage.EXCEED_CAR_NAME_LENGTH);
                    racingCarSimulator.setRacingCarList(carNameList);
                })
                .withMessage(ExceptionMessage.EXCEED_CAR_NAME_LENGTH.getExceptionMessage());
    }

    private int getCarNum(String carNames) {

        return StringUtils.getParsedStringList(carNames, RacingCarSimulator.CAR_NAME_DELIMITER).size();
    }

    /*
        0번 차와 2번차가 1씩 이동을 시도했으므로 어떠한 경우에도 우승자 리스트에는 0번차나 2번차중 하나는 포함되어야 한다.
     */
    @DisplayName("findWinners() 메소드 검증")
    @RepeatedTest(1000)
    void findWinnersTest() {

        // given
        RacingCarSimulator racingCarSimulator = new RacingCarSimulator();
        racingCarSimulator.setRacingCarList(Arrays.asList("winner1", "noWinner1", "winner2", "noWinner2"));
        List<RacingCar> racingCarList = racingCarSimulator.getRacingCarList();
        racingCarList.get(0).moveForward(1);
        racingCarList.get(2).moveForward(1);

        // when
        List<RacingCar> result = racingCarSimulator.findWinners();

        // then
        assertThat(result).containsAnyOf(racingCarList.get(0), racingCarList.get(2));
    }

}
