package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RoundStatusTest {

    @Test
    void 라운드가_남아있으면_hasNextRound는_true를_반환한다() {
        RoundStatus roundStatus = new RoundStatus(3);

        assertThat(roundStatus.hasNextRound()).isTrue();
    }

    @Test
    void 모든_라운드를_진행하면_hasNextRound는_false를_반환한다() {
        RoundStatus roundStatus = new RoundStatus(1);

        roundStatus.next();

        assertThat(roundStatus.hasNextRound()).isFalse();
    }

    @Test
    void next를_호출하면_현재_라운드가_증가한다() {
        RoundStatus roundStatus = new RoundStatus(5);

        assertThat(roundStatus.getCurrentRound()).isEqualTo(0);

        roundStatus.next();
        assertThat(roundStatus.getCurrentRound()).isEqualTo(1);
    }

    @Test
    void 더_이상_진행할_라운드가_없으면_예외가_발생한다() {
        RoundStatus roundStatus = new RoundStatus(1);

        roundStatus.next();

        assertThatThrownBy(() -> roundStatus.next())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("다음 라운드가 없습니다");
    }


    @Test
    void 라운드_상태_초기값은_0이다() {
        RoundStatus roundStatus = new RoundStatus(5);

        assertThat(roundStatus.getCurrentRound()).isEqualTo(0);
    }


}
