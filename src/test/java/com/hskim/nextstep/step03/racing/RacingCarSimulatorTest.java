package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step02.utils.StringUtils;
import com.hskim.nextstep.step03.exception.ExceptionMessage;
import com.hskim.nextstep.step03.model.RacingCar;
import com.hskim.nextstep.step03.utils.ValidationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/*
    com.hskim.nextstep.step03 - RacingCarSimulator class 테스트
 */
public class RacingCarSimulatorTest {

    private RacingCarSimulator racingCarSimulator;

//    @BeforeEach
//    void setUp() {
//
//        racingCarSimulator = new RacingCarSimulator();
//    }
//

//    /*
//        0번 차와 2번차가 1씩 이동을 시도했으므로 어떠한 경우에도 우승자 리스트에는 0번차나 2번차중 하나는 포함되어야 한다.
//     */
//    @DisplayName("findWinners() 메소드 검증")
//    @RepeatedTest(1000)
//    void findWinnersTest() {
//
//        // given
//        RacingCarSimulator racingCarSimulator = new RacingCarSimulator();
//        racingCarSimulator.setRacingCarList(Arrays.asList("winner1", "noWinner1", "winner2", "noWinner2"));
//        List<RacingCar> racingCarList = racingCarSimulator.getRacingCarList();
//        racingCarList.get(0).moveForward(1);
//        racingCarList.get(2).moveForward(1);
//
//        // when
//        List<RacingCar> result = racingCarSimulator.findWinners();
//
//        // then
//        assertThat(result).containsAnyOf(racingCarList.get(0), racingCarList.get(2));
//    }

}
