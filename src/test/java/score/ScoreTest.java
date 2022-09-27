package score;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {
    private final Score score = new Score();

    @Test
    void run() {
        assertThat(score.run()).isEqualTo(1);
    }

    @Test
    void getScore() {
    }
}