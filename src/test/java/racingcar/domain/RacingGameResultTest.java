package racingcar.domain;

import org.junit.Test;
import racingcar.domain.RacingGameResultSet;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {

    @Test
    public void 레이싱지동차_이름과_위치로_레이싱결과를_생성할수있다() {
        RacingGameResultSet.RacingGameResult result = RacingGameResultSet.RacingGameResult.of("pobi", 1);
        assertThat(result).isNotNull();
    }

    @Test
    public void 레이싱결과로_랭킹여부를_알수있다() {
        RacingGameResultSet.RacingGameResult result = RacingGameResultSet.RacingGameResult.of("pobi", 4);
        assertThat(result.isRanking(3)).isTrue();
        assertThat(result.isRanking(4)).isTrue();
        assertThat(result.isRanking(5)).isFalse();
    }
}