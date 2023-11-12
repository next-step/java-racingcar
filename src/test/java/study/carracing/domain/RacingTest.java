package study.carracing.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {
    private Racing racing = new Racing();

    @Test
    @DisplayName("게임 히스토리 값을 변경하면 UnsupportedOperationException예외가 발생한다.")
    void not_allow_to_modify_history() {
        racing.start("car1,car2,car3".split(","), 3);
        List<String> scores = racing.getHistory().getScores();

        assertThatThrownBy(() -> scores.add("test score"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("꺼내온 우승자 리스트의 값을 변경하면 UnsupportedOperationException예외가 발생한다.")
    void not_allow_to_modify_winners() {
        racing.start("car1,car2,car3".split(","), 3);
        List<String> winners = racing.winners();

        assertThatThrownBy(() -> winners.add("new winner"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}