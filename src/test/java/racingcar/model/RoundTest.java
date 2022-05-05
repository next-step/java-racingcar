package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {
    @Test
    @DisplayName("Round 객체를 만들 때 0 이하의 수를 입력하면 예외가 발생한다.")
    void create_round_negative() throws Exception {
        assertThatThrownBy(() -> Round.create(0))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("라운드가 다 할때까지 반복문을 돌려 남은 라운드가 있는지 확인한다.")
    void check_the_remaining_round() {
        Round round = Round.create(3);

        while (round.checkRound()) {
            round = round.decrease();
        }

        assertThat(round.getValue()).isZero();
    }

    @Test
    @DisplayName("라운드가 감소했는지 확인한다.")
    void check_decrease_round() {
        Round round = Round.create(3);
        round = round.decrease();
        assertThat(round).isEqualTo(Round.create(2));
    }
}
