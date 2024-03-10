package racingcar;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 이름이 들어오면 예외가 발생한다")
    void fail_for_empty_or_null(String input) {
        assertThatThrownBy(() -> new Name(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void fail_for_greater_than_5_length() {
        assertThatThrownBy(() -> new Name("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde"})
    @DisplayName("1~5자라면 문제없이 생성된다")
    void success_for_1_to_5_length(String input) {
        assertThatNoException()
            .isThrownBy(() -> new Name(input));
    }
}
