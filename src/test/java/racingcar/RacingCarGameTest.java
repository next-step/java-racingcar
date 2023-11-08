package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.rule.MinimumRule;
import racingcar.util.BasicNumberGenerator;
import racingcar.view.CountView;
import racingcar.view.ResultView;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    /*
    --------------------------------------------------------------------------------
    - 단위 테스트
    --------------------------------------------------------------------------------
     */



    /*
    ----------------------------------------------------------------------------
    - 통합 테스트
    ----------------------------------------------------------------------------
    */

    @Test
    @DisplayName("경기를 시작한다, 승자결과를 호출하면 '~가 최종 우승했습니다.' 라는 메시지를 표시한다")
    void race_start() {

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int carCount = 3;
        int raceCount = 5;

        RacingCarGame racingCarGame = new RacingCarGame(
                new CountView(carCount, raceCount),
                new ResultView(),
                new MinimumRule(4, new BasicNumberGenerator(9))
        );

        racingCarGame.start();
        racingCarGame.winnerResult();

        assertThat(out.toString()).contains("최종 우승했습니다");
    }
}