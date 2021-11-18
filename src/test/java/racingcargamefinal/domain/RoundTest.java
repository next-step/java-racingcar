package racingcargamefinal.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    private final Round oneRound = new Round(1);
    private final Round zeroRound = new Round(0);

    @Test
    void create() {
        assertThat(oneRound).isInstanceOf(Round.class);
    }

    @Test
    void createFail() {
        assertThatThrownBy(() -> {
            new Round(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라운드는 0 미만일 수 없습니다.");
    }

    @Test
    void isEnd() {
        assertThat(oneRound.isEnd()).isFalse();
        assertThat(zeroRound.isEnd()).isTrue();
    }

    @Test
    void play() {
        Round round = oneRound.play();
        assertThat(round.isEnd()).isTrue();
    }

    @Test
    void playFail() {
        assertThatThrownBy(() -> {
            zeroRound.play();
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("모든 라운드가 끝났습니다.");
    }

}
