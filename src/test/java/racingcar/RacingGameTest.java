package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 클래스의 테스트")
class RacingGameTest {

    @ParameterizedTest
    @DisplayName("tryNum 보다 많이 play 하면 gameOver 되어야 한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void play(int loop) {
        int carNum = 3;
        int tryNum = 5;
        MoveStrategy strategy = Mockito.mock(MoveStrategy.class);
        CarCollection collection = new CarCollection(carNum, strategy);
        RacingGame game = new RacingGame(collection, tryNum);

        for (int i = 0; i < loop; i++) {
            game.play();
        }

        boolean expectedGameOver = loop < tryNum;
        assertThat(game.checkNotGameOver())
                .isEqualTo(expectedGameOver);
    }
}
