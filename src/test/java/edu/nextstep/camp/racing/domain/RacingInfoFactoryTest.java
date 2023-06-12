package edu.nextstep.camp.racing.domain;

import edu.nextstep.camp.testUtils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingInfoFactoryTest {

    @Test
    void 레이싱_정보_입력시_재입력_테스트(){
        TestUtils.systemSetIn("TEST,TEST\n5\nTEST1,TEST2\n10");
        RacingInfoFactory racingInfoFactory = new RacingInfoFactory();

        RacingInfo racingInfo = racingInfoFactory.createRacingInfo();

        assertAll(
                ()-> assertThat(racingInfo.getCarNames()).contains("TEST1", "TEST2"),
                ()-> assertThat(racingInfo.getMovingCount()).isEqualTo(10)
        );
    }
}
