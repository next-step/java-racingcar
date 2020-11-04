package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 클래스의 테스트")
class RacingGameTest {

    @ParameterizedTest
    @DisplayName("tryNum 보다 많이 play 하면 gameOver 되어야 한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void play(int loop) {
        String nameCsv = "1,2,3";
        int tryNum = 5;
        RacingGame game = new RacingGame(nameCsv, tryNum);

        for (int i = 0; i < loop; i++) {
            game.play();
        }

        boolean expectedGameOver = loop < tryNum;
        assertThat(game.checkNotGameOver())
                .isEqualTo(expectedGameOver);
    }
}
