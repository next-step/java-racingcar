package step3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {

    @Test
    public void inputValidationCheckTest(){

        RacingGame racingGame = new RacingGame();

        assertThatIllegalArgumentException().isThrownBy(
                () -> racingGame.setInputValues(-1, 0)
        );
    }

    @Test
    public void moveTest(){

        // given
        RacingGame racingGame = new RacingGame();
        racingGame.setInputValues(3, 5);

        // when
        int[] result = racingGame.move();

        // then
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void gameResultTest(){

        // given
        RacingGame racingGame = new RacingGame();
        racingGame.setInputValues(3, 5);

        // when
        List<int[]> result = racingGame.getResult();

        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}