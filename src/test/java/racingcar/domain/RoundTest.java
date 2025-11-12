package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RoundTest {

    @Test
    void 생성자_시작_라운드는_1() {
        assertThat(new Round(5).getCurrentRound()).isEqualTo(1);
    }

    @Test
    void 생성자_1_미만이면_예외발생() {
        assertThatThrownBy(() -> new Round(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대 라운드 수는 1이상이어야 합니다.");
    }

    @Test
    void next_현재_라운드_1_증가() {
        Round round = new Round(3);

        round.next();

        assertThat(round.getCurrentRound()).isEqualTo(2);
    }

    @Test
    void isFinished_라운드가_종료되었는지_상태반환() {
        Round round = new Round(2);

        round.next();

        assertThat(round.isFinished()).isTrue();
    }
}
