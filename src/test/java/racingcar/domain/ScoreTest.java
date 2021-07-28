package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {
    @DisplayName("add하면 score가 올라가야한다.")
    @Test
    void add() {
        Score score = new Score();
        score.add();
        assertThat(score.getNumber()).isEqualTo(1);
    }

    @DisplayName("score 동등 비교")
    @Test
    void equals() {
        Score score = new Score();
        score.add();
        Score sameScore = new Score(1);
        assertThat(score.equals(sameScore)).isTrue();
    }
}
