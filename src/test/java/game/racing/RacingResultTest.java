package game.racing;

import game.racing.domain.RacingResult;
import game.racing.domain.TrackingLog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : yusik
 * @date : 2019/10/28
 */
public class RacingResultTest {

    @DisplayName("레이싱 실행 결과 생성 및 가져오기")
    @Test
    void getExecutionResults() {

        // given
        int expected = 1;
        RacingResult result = new RacingResult();
        result.register("test1");

        // when
        List<TrackingLog> executionResults = result.getTrackingLogs();

        // then
        assertThat(executionResults.size()).isEqualTo(expected);
    }
}
