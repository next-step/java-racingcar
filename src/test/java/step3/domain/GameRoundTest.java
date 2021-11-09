package step3.domain;

import org.junit.jupiter.api.Test;
import step3.service.RandomIntNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameRoundTest {

    @Test
    void 게임_라운드를_생성한다() {
        //given
        GameRound gameRound = GameRound.create(1, new RandomIntNumberGenerator());
        //when & then
        assertThat(gameRound).isNotNull();
    }

    @Test
    void 게임_라운드가_0이하면_IllegalArgumentException이_발생한다() {
        //given
        //when & then
        assertThatThrownBy(() -> GameRound.create(0, new RandomIntNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
