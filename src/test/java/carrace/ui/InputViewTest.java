package carrace.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    @DisplayName("이름 5자 이하일때 넘어가는지 검증")
    void validateCarNames() {
        InputView.validateCarNames(new String[]{"pobi", "crong", "honux"});
    }

    @Test
    @DisplayName("이름 5자 초과일때 익셉션 검증")
    void validateCarNamesException() {
        assertThatThrownBy(() -> {
            InputView.validateCarNames(new String[]{"pobi", "crong", "honux", "pilhwankim"});
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            InputView.validateCarNames(new String[]{"pobi", "abcdef", "crong", "honux"});
        }).isInstanceOf(IllegalArgumentException.class);
    }
}