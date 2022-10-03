package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ui.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class IOViewTest {

    @Test
    @DisplayName("위치에 맞는 출력")
    void resultPathTest() {
        assertThat(ResultView.getPathString(3)).isEqualTo("---");
    }
}
