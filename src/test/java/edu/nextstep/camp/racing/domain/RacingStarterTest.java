package edu.nextstep.camp.racing.domain;

import edu.nextstep.camp.testUtils.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.OutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingStarterTest {


    @ParameterizedTest
    @ValueSource(strings = {"TEST1,TEST2,TEST3\n7", "TEST123,TEST2\n3\nTEST1,TEST2\n6"})
    void 레이싱_시작_테스트(String param){
        TestUtils.systemSetIn(param);
        OutputStream outputStream = TestUtils.getOutputStream();

        RacingStarter racingStarter = new RacingStarter(new RacingInfoFactory());

        racingStarter.start();
        String resultMsg = outputStream.toString();

        assertThat(resultMsg).contains("(이)가 최종 우승했습니다.");
    }

}
