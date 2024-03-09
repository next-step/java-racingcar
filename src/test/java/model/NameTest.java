package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"ponito", "nextstep"})
    void 자동차_이름이_5자를_초과하면_예외가_발생한다(final String name) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }
}
