package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @DisplayName("쉼표로 구분된 이름을 나눈다")
    @Test
    void splitNames() {
        assertThat(InputView.splitNames("pobi,crong,honux"))
                .containsExactly("pobi", "crong", "honux");
    }

    @DisplayName("쉼표가 없으면 이름이 하나다")
    @Test
    void splitSingleName() {
        assertThat(InputView.splitNames("pobi"))
                .containsExactly("pobi");
    }
}
