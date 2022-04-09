package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceTest {
    @Test
    void 자동차_대수가_0대일때() {
        assertThatThrownBy(() -> Race.start(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}