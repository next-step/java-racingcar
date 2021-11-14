package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step3.repository.GameHistory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameHistoryTest {

    @Test
    void 게임_기록을_생성한다() {
        //given
        GameHistory gameHistory = GameHistory.create();
        //when & then
        assertNotNull(gameHistory);
    }

    @Test
    void 게임_라운드를_기록한다() {
        //given
        GameHistory gameHistory = GameHistory.create();
        Cars cars = Cars.create("java,c,go");
        //when
        gameHistory.record(0, RoundHistory.of(cars));
        //then
        assertNotNull(gameHistory.getBy(0));
    }

    @Test
    void 존재하지_않는_라운드를_조회하면_IllegalArgumentException_이_발생한다() {
        //given
        GameHistory gameHistory = GameHistory.create();
        //when & then
        Assertions.assertThatThrownBy(() -> gameHistory.getBy(0));
    }
}
