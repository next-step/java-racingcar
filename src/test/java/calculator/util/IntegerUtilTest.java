package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerUtilTest {

    @DisplayName("int 값이 0이 아니면 return false")
    @ParameterizedTest
    @ValueSource(ints = { 1, 100, 10000, 1000000 })
    void isNotZero(final int value) {
        assertThat(IntegerUtil.isZero(value)).isFalse();
    }

    @DisplayName("int 값이 0이면 return true")
    @Test
    void isZero() {
        assertThat(IntegerUtil.isZero(0)).isTrue();
    }
}
