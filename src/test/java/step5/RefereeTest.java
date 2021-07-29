package step5;

import org.junit.jupiter.api.Test;
import step5.domain.Referee;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    void 주어진_시간보다_시간이_지났다면_RETURN_TRUE() {
        // given
        int givenTime = 5;
        Referee referee = new Referee(givenTime);

        // when
        for (int i = 0; i < 5; i++) {
            referee.passedTime();
        }

        // then
        assertThat(referee.isOverTime()).isTrue();
    }

    @Test
    void 주어진_시간보다_시간이_안_지났다면_isOverTime_RETURN_FALSE() {
        // given
        int givenTime = 5;
        Referee referee = new Referee(givenTime);

        // when
        for (int i = 0; i < 2; i++) {
            referee.passedTime();
        }

        // then
        assertThat(referee.isOverTime()).isFalse();
    }

}