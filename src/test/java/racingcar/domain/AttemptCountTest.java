package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 시도_횟수가_0_또는_음수이면_예외를_던진다(int value) {
        assertThatThrownBy(() -> new AttemptCount(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}