package racingcar.model.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {


    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("총 라운드 횟수는 0이하일 수 없다")
    public void positiveRound(int totalRound) {
        assertThatThrownBy(() -> new Round(totalRound))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("현재 라운드를 알 수 있다")
    public void current() {
        Round round = new Round(10);
        round.next();

        assertThat(round.current()).isEqualTo(1);
    }


    @Test
    @DisplayName("라운드 종료 여부를 판단할 수 있다")
    public void over() {
        Round round = new Round(1);
        round.next();

        assertThat(round.isOver()).isTrue();
    }

    @Test
    @DisplayName("라운드 미종료 여부를 판단할 수 있다")
    public void notOver() {
        Round round = new Round(2);
        round.next();

        assertThat(round.isOver()).isFalse();
    }

    @Test
    @DisplayName("총 라운드 횟수를 초과하면 예외가 발생")
    public void cannotOverTotalRound() {
        Round round = new Round(1);
        round.next();
        assertThatThrownBy(round::next)
                .isInstanceOf(IllegalStateException.class);
    }

}