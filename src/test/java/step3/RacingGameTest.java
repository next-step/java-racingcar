package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;

class RacingGameTest {

    RacingGame racingGame = new RacingGame(5,2);

    @RepeatedTest(10)
    void getRandomPosition() {
        assertThat(racingGame.getRandomPosition()).isBetween(0, 10);
    }

    @RepeatedTest(10)
    void move() {
        //when
        int[] result = racingGame.move();

        //then
        for (int i = 0; i < result.length; ++i) {
            assertThat(result[i]).isGreaterThanOrEqualTo(0);
        }
    }
}