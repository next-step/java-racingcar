package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class NameTest {
    @DisplayName("자동차명이 5글자를 초과할떄 exception test")
    @ParameterizedTest
    @ValueSource(strings = {"nextstep", "unlucky"})
    void validate_carName(String input) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new Name(input)).withMessageMatching("이름은 5글자를 넘길 수 없습니다 : .*");
    }
}
