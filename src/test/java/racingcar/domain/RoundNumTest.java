package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RoundNumTest {
    @Test
    void checkValidRoundNum() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    RoundNum roundNum = new RoundNum(-1);
                });
    }

    @Test
    void runOneRound() {
        int round = 3;
        RoundNum roundNum = new RoundNum(round);
        assertThat(roundNum.runOneRound()).isEqualToComparingFieldByField(new RoundNum(round - 1));
    }

    @Test
    void isRoundOver() {
        int round = 3;
        RoundNum roundNum = new RoundNum(round);
        for (int i = 0; i < round; i++) {
            roundNum = roundNum.runOneRound();
        }

        assertThat(roundNum.isRoundOver()).isTrue();
    }
}
