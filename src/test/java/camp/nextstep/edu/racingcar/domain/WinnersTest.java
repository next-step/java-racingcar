package camp.nextstep.edu.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.racingcar.domain.result.DriveResult;
import camp.nextstep.edu.racingcar.domain.result.RoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {

    @Test
    @DisplayName("점수가 가장 높은 우승자 1명의 배열을 반환한다")
    void oneWinner() {
        // given
        RoundResult roundResult = new RoundResult();
        roundResult.report(new DriveResult("a", 5));
        roundResult.report(new DriveResult("b", 2));

        // when
        String[] winners = Winners.getWinners(roundResult);

        // then
        assertThat(winners).containsExactly("a");
    }

    @Test
    @DisplayName("점수가 가장 높은 공동 우승자들의 배열을 반환한다")
    void multiWinner() {
        // given
        RoundResult roundResult = new RoundResult();
        roundResult.report(new DriveResult("a", 5));
        roundResult.report(new DriveResult("b", 2));
        roundResult.report(new DriveResult("c", 5));

        // when
        String[] winners = Winners.getWinners(roundResult);

        // then
        assertThat(winners).containsExactly("a", "c");
    }
}
