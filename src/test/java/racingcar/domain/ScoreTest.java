package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {
    @DisplayName("score 동등 비교")
    @Test
    void equals() {
        Score score = new Score();
        Score sameScore = new Score(1);
        assertThat(score.getAddedScore().equals(sameScore)).isTrue();
    }
}
