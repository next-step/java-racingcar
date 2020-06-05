package study.nextstep.stage5.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class GameStatusTest {
    @Test
    public void invalidGameStatusInitializeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new GameStatus(-1, 1));
        assertThatIllegalArgumentException().isThrownBy(() -> new GameStatus(1, -1));
    }

    @Test
    public void notGameFinishedTest() {
        GameStatus status = new GameStatus(1, 3);
        assertThatIllegalArgumentException().isThrownBy(() -> status.getWinnerPosition());
    }

    @Test
    public void singleUserFinishTest() {
        GameStatus status = new GameStatus(1, 2);
        while (status.totalTurn(new Random()));
        assertThat(status.getWinnerNames(new String[]{"names"})).isEqualTo("names");
    }

    @Test
    public void multiUserEveryOneWinTest() {
        GameStatus status = new GameStatus(5, 2);
        while (status.totalTurn(new Random() {
            @Override
            public int nextInt(int bound) {
                return bound - 1;
            }
        }));
        assertThat(status.getWinnerPosition().size()).isEqualTo(5);
    }

    @Test
    public void nobodyMovedTest() {
        GameStatus status = new GameStatus(5, 2);
        while (status.totalTurn(new Random() {
            @Override
            public int nextInt(int bound) {
                return bound - 1;
            }
        }));
        assertThat(status.getWinnerPosition().size()).isEqualTo(5);
    }

    @Test
    public void firstRunnerWinTest() {
        GameStatus status = new GameStatus(3, 3);
        while (status.totalTurn(new Random() {
            boolean isFirstRunner = true;
            @Override
            public int nextInt(int bound) {
                if (isFirstRunner) {
                    isFirstRunner = false;
                    return bound - 1;
                }
                return 0;
            }
        }));
        assertThat(status.getWinnerPosition().size()).isEqualTo(1);
        assertThat(status.getWinnerPosition().get(0)).isEqualTo(0);
    }
}
