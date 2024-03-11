package model;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-5, -3, -1, 0})
    void 시도_횟수가_0이하이면_예외가_발생한다(final int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new TryNumber(value));
    }
}
