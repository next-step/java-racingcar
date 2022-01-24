package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @Test
    void 라운드_생성_테스트() {
        Round round = new Round("12");
        assertThat(round.getRound()).isEqualTo(12);
    }

    @Test
    void 라운드_생성_예외_테스트() {
        assertThatThrownBy(() -> new Round("pan"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Round("-2"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 라운드_진행_테스트() {
        //given
        Round round = new Round("1");
        //when
        round.untilEnd();
        //then
        assertThat(round.untilEnd()).isFalse();
    }
}
