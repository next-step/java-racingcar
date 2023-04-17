package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @DisplayName("정상적인 값을 입력 받으면 RacingGame 이 정상적을 수행된다.")
    @Test
    public void RacingGame_gameStart_정상_테스트() {

        RacingGame racingGame = new RacingGame(new RacingGameInputs(5, "pobbi,crong,honux"));

        racingGame.gameStart();
    }

    @DisplayName("비정상적인 값을 입력 받으면 RacingGame 이 수행되지 못한다.")
    @Test
    public void RacingGame_gameStart_비정상_테스트() {

        assertThatThrownBy(() ->
                new RacingGame(new RacingGameInputs(5, "pobbi,tester,honux")).gameStart())
                .isInstanceOf(InputMismatchException.class);
    }
}
