import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    @DisplayName("쉼표(,)를 기준으로 입력받은 자동차 이름을 분리한다.")
    void inputCarNameTest() {
        String input = "pobi,crong,honux\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<String> strings = InputView.readCarNamesInput();
        assertThat(strings).hasSize(3);
    }

    @Test
    @DisplayName("이름 중에 5글자 초과인 자동차가 있으면 실패한다.")
    void invalidCarNameTest() {
        String input = "pobi12345,crong,honux\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::readCarNamesInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자를 초과할 수 없습니다.");
    }
}