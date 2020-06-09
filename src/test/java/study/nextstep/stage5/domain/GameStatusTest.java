package study.nextstep.stage5.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class GameStatusTest {
    @Test
    public void invalidGameStatusInitializeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new GameStatus(null, 1));
        assertThatIllegalArgumentException().isThrownBy(() -> new GameStatus(new String[]{"test"}, -1));
    }

    @Test
    public void notGameFinishedTest() {
        GameStatus status = new GameStatus(new String[]{"test"}, 3);
        assertThatIllegalArgumentException().isThrownBy(() -> status.getWinnerPosition());
    }

    @Test
    public void singleUserFinishTest() {
        GameStatus status = new GameStatus(new String[]{"names"}, 2);
        while (status.totalTurn(new Random()));
        assertThat(status.getWinnerNames()).isEqualTo("names");
    }

    @Test
    public void multiUserEveryOneWinTest() {
        GameStatus status = new GameStatus(new String[]{"one", "two", "three", "four", "five"}, 2);
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
        GameStatus status = new GameStatus(new String[]{"one", "two", "three", "four", "five"}, 2);
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
        GameStatus status = new GameStatus(new String[]{"one", "two", "three"}, 3);
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
        assertThat(status.getWinnerNames()).isEqualTo("one");
    }
}
