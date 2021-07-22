package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    void 주어진_5초가_지나면_더_이상_움직이면_안된다() {
        // given
        int givenTime = 5;
        Referee referee = new Referee(givenTime);

        // when
        for (int i = 0; i < 5; i++) {
            referee.hasPassedTime();
        }

        // then
        assertThat(referee.isOverTheTime()).isTrue();
    }

    @Test
    void 주어진_5초가_지나지않았다면_움직일_수_있다() {
        // given
        int givenTime = 5;
        Referee referee = new Referee(givenTime);

        // when
        for (int i = 0; i < 2; i++) {
            referee.hasPassedTime();
        }

        // then
        assertThat(referee.isOverTheTime()).isFalse();
    }

}