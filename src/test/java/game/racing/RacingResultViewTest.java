package game.racing;

import game.ResultEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by kohyusik on 29/10/2019.
 */
public class RacingResultViewTest {

    @DisplayName("로그 출력 테스트")
    @Test
    void name() {
        RacingResult result = new RacingResult();
        TrackingLog log = result.register("test");
        log.add(5);
        RacingResultView resultView = new RacingResultView();
        resultView.render(new ResultEntity<>(result));
    }
}
