package carrace.view;

import carrace.view.input.scanner.NameValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameValidatorTest {

    @Test
    @DisplayName("이름 5자 이하일때 넘어가는지 검증")
    void validateCarNames() {
        NameValidator.validateCarNames(new String[]{"pobi", "crong", "honux"});
    }

    @Test
    @DisplayName("이름 5자 초과일때 익셉션 검증")
    void validateCarNamesException() {
        assertThatThrownBy(() -> {
            NameValidator.validateCarNames(new String[]{"pobi", "crong", "honux", "pilhwankim"});
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            NameValidator.validateCarNames(new String[]{"pobi", "abcdef", "crong", "honux"});
        }).isInstanceOf(IllegalArgumentException.class);
    }
}