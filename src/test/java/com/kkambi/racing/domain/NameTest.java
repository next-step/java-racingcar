package com.kkambi.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @DisplayName("이름은 5글자를 초과할 수 없다")
    @ValueSource(strings = {"123456", "coding"})
    @ParameterizedTest
    void nameMustNotOver5(String name) {
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }
}