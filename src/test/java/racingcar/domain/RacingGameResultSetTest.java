package racingcar.domain;

import org.junit.Test;
import racingcar.domain.RacingGameResultSet;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultSetTest {

    @Test
    public void 레이싱결과_리스트로_레이싱결과셋을_생성할수있다() {
        List<RacingGameResultSet.RacingGameResult> results = Arrays.asList(
                RacingGameResultSet.RacingGameResult.of("pobi", 1),
                RacingGameResultSet.RacingGameResult.of("crong", 1),
                RacingGameResultSet.RacingGameResult.of("honux", 1)
        );
        RacingGameResultSet racingGameResultSet = RacingGameResultSet.of(results);
        assertThat(racingGameResultSet).isNotNull();
    }

    @Test
    public void 레이싱결과셋의_우승자이름을_알수있다() {
        List<RacingGameResultSet.RacingGameResult> results = Arrays.asList(
                RacingGameResultSet.RacingGameResult.of("pobi", 3),
                RacingGameResultSet.RacingGameResult.of("crong", 4),
                RacingGameResultSet.RacingGameResult.of("honux", 4)
        );
        RacingGameResultSet racingGameResultSet = RacingGameResultSet.of(results);
        assertThat(racingGameResultSet.getRacingGameWinner()).isEqualTo("crong, honux");
    }
}