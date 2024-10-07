package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {

    @Test
    @DisplayName("매치 카운트가 0 이하일 때 매치가 종료된다.")
    void 매치_종료() {
        Match match = new Match(0);
        assertThat(match.isMatching()).isFalse();
    }

    @Test
    @DisplayName("매치 카운트가 1 이상일 때 매치가 진행중이다.")
    void 매치_진행중() {
        Match match = new Match(1);
        assertThat(match.isMatching()).isTrue();
    }

    @Test
    @DisplayName("매치를 하게되면 매치가 감소한다.")
    void 매치_감소() {
        Match match = new Match(5);
        match.match();
        assertThat(match).isEqualTo(new Match(4));
    }
}
