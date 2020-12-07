package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차경주(RacingGame) 테스트")
public class RacingGameTest {

    @DisplayName("이동 규칙(MoveAble)의 생성자 주입으로 생성된다.")
    @Test
    void create() {
        // given
        Moveable moveable = () -> true;

        // when
        RacingGame racingGame = new RacingGame(moveable);

        // then
        assertThat(racingGame).isNotNull();
    }

    @DisplayName("게임 보고서(GameReport)를 만들 수 있다.")
    @Test
    void report() {
        // given
        Moveable moveable = () -> true;
        int round = 5;

        // when””
        RacingGame racingGame = new RacingGame(moveable);
        GameReport gameReport = racingGame.play(round, Cars.of(new ArrayList<>()));

        // then
        assertThat(gameReport).isNotNull();
    }
}
