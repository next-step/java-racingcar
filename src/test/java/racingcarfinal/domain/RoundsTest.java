package racingcarfinal.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundsTest {

    private final Rounds roundsOne = new Rounds(1);
    private final Rounds roundsZero = new Rounds(0);

    @Test
    void create() {
        assertThat(roundsOne).isInstanceOf(Rounds.class);
    }

    @Test
    void createFail() {
        assertThatThrownBy(() -> {
            new Rounds(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("round 수는 0 미만일 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,false", "0,true"})
    void isEnd(int roundCount, boolean isEnd) {
        Rounds rounds = new Rounds(roundCount);
        assertThat(rounds.isEnd()).isEqualTo(isEnd);
    }

    @Test
    void play() {
        roundsOne.play();
        assertThat(roundsOne.isEnd()).isTrue();
    }

    @Test
    void playFail() {
        assertThatThrownBy(() -> {
            roundsZero.play();
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("모든 round가 끝났습니다.");
    }

}
