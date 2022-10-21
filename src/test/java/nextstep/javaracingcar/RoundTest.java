package nextstep.javaracingcar;

import nextstep.javaracingcar.domain.Round;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @DisplayName("거리는 음수가 허용되지 않는다.")
    @Test
    public void spec01() {
        assertThatThrownBy(() -> new Round(-1)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Round(-2)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("실행 가능한 라운드가 있는지 확인 가능하다.")
    @Test
    public void spec02() {
        assertThat(new Round(0).hasNextRound()).isFalse();
        assertThat(new Round(1).hasNextRound()).isTrue();
        assertThat(new Round(2).hasNextRound()).isTrue();
    }

    @DisplayName("실행 가능한 라운드가 있는지 확인 가능하다.")
    @Test
    public void spec03() {
        assertThatThrownBy(() -> new Round(0).run()).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("라운드를 진행시 남은 라운드 수가 하나 감소한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 39})
    public void spec04(final int roundCount) {
        final Round round = new Round(roundCount);
        for (int i = 0; i < roundCount; i++) {
            round.run();
        }
        assertThat(round.hasNextRound()).isFalse();
    }
}
