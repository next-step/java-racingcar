package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerTest {

    @Test
    @DisplayName("경주차 게임 우승자를 알려준다.")
    void inform_winner() {
        // given
        Winner winner = new Winner();
        String gameResult = "k5 : ----\n"
                + "k3 : --\n"
                + "k7 : ----\n";

        // when
        String winners = winner.inform(gameResult);

        // then
        assertThat(winners).isEqualTo("k5,k7");
    }
}
