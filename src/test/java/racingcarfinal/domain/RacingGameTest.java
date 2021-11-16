package racingcarfinal.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    private final String carNames = "pobi";
    private final int roundCountOne = 1;
    private final int roundCountZero = 0;

    @ParameterizedTest
    @CsvSource(value = {"1,false", "0,true"})
    void isEnd(int roundCount, boolean isEnd) {
        RacingGame game = new RacingGame("pobi", roundCount);
        assertThat(game.isEnd()).isEqualTo(isEnd);
    }

    @Test
    void play() {
        RacingGame oneGame = new RacingGame(carNames, roundCountOne);

        oneGame.play();

        assertThat(oneGame.isEnd()).isTrue();
    }

    @Test
    void playFail() {
        RacingGame zeroGame = new RacingGame(carNames, roundCountZero);

        assertThatThrownBy(() -> {
            zeroGame.play();
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("모든 round가 끝났습니다.");
    }

}
