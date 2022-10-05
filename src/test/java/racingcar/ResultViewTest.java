package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ui.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    @DisplayName("위치에 맞는 출력")
    void resultPathTest() {
        assertThat(ResultView.getPathString(3)).isEqualTo("---");
    }

    @Test
    @DisplayName("이름과 위치에 맞는 출력")
    void roundResult() {
        assertThat(ResultView.getRoundResultStr("pobi", 3)).isEqualTo("pobi : ---");
    }
}
