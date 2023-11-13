package study.carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.carracing.fake.TestMoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HistoryTest {

    @Test
    @DisplayName("게임 히스토리 값을 변경하면 UnsupportedOperationException예외가 발생한다.")
    void not_allow_to_modify_racingCars() {
        Racing racing = new Racing(new TestMoveStrategy());
        racing.start("car1,car2,car3".split(","), 3);
        History history = new History();
        List<String> scores = history.getScores();

        assertThatThrownBy(() -> scores.add("test score"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
