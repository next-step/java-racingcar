package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.random.RandomStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("움직일 수 있는 기회가 1번인 경우 RacingGame 경기가 정상적으로 작동하는지 체크한다")
    void startWithOneMoveTest() {
        // given
        RacingGame game = new RacingGame(3, 1, new RandomStrategy() {
            private int index = 0;
            private final int[] values = {6, 2, 4};

            @Override
            public int generateRandomValue() {
                return values[index++];
            }
        });
        String expected = "\n-" +       // 첫번째 차는 6이므로 움직임
                "\n" +                  // 두번째 차는 2이므로 움직이지 않음
                "\n-" +                 // 세번째 차는 4이므로 움직임
                "\n";                   // 개행

        // when & then
        assertThat(game.start()).isEqualTo(expected);
    }

    @Test
    @DisplayName("움직일 수 있는 기회가 여러번인 경우 RacingGame 경기가 정상적으로 작동하는지 체크한다")
    void startTest1() {
        // given
        RacingGame game = new RacingGame(2, 2, new RandomStrategy() {
            private int index = 0;
            private final int[] values = {6, 2, 3, 4};

            @Override
            public int generateRandomValue() {

                return values[index++];
            }
        });
        String expected = "\n-" +   // 첫번째 차는 6이므로 움직임
                "\n" +              // 두번째 차는 2이므로 움직이지 않음
                "\n\n" +            // 개행
                "-\n" +             // 첫번째 차는 3이므로 움직이지 않음
                "-\n";              // 두번째 차는 4이므로 움직임

        // when & then
        assertThat(game.start()).isEqualTo(expected);
    }
}
