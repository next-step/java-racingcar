package game.domain;

import game.util.NumberUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"-3", "0", "+"})
    @DisplayName("0, 음의 정수, 문자")
    void checkRuntimeException(String value) {
        Assertions.assertThatThrownBy(() -> {
            NumberUtil.toNaturalNumber(value);
        }).isInstanceOf(RuntimeException.class);
    }
}