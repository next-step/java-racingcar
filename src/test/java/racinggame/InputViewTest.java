package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @DisplayName("입력받은 문자열을 , 로 분리")
    @Test
    void test1() {
        InputView inputView = new InputView();
        assertThat(inputView.splitCarName("pobi,crong,honux")).containsExactly("pobi", "crong", "honux");
    }

}
