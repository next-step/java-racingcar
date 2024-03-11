package model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"ponito", "nextstep"})
    void 자동차_이름이_5자를_초과하면_예외가_발생한다(final String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 이름이_null이거나_빈_문자열인_경우_예외가_발생한다(final String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }
}
