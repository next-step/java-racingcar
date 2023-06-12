package edu.nextstep.camp.racing.domain;

import edu.nextstep.camp.testUtils.TestUtils;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 례이싱_게임_시작_테스트(){
        RacingInfo racingInfo = RacingInfo.of("TEST1,TEST2,TEST3", 5);
        RacingGame racingGame = new RacingGame(racingInfo);

        OutputStream outputStream = TestUtils.getOutputStream();
        racingGame.startGame();
        String resultMsg = outputStream.toString();

        assertThat(resultMsg).contains("(이)가 최종 우승했습니다.");
    }
}
