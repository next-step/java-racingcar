package game.core.domain;

import game.racing.domain.RacingResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/02.
 */
public class ResultEntityTest {

    @DisplayName("결과값 테스트")
    @Test
    void getInput() {

        // given
        RacingResult result = new RacingResult();

        // when
        ResultEntity<RacingResult> resultEntity = new ResultEntity<>(result);

        //then
        assertThat(resultEntity.getResult().getClass()).isEqualTo(RacingResult.class);

    }
}
