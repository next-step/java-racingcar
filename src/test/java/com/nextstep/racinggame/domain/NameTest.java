package com.nextstep.racinggame.domain;

import com.nextstep.racinggame.domain.exceptions.InvalidNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @DisplayName("5자 이내의 문자열로 객체를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"안녕하세요", "12345", "123 ", "  "})
    void createTest(String nameValue) {
        assertThat(new Name(nameValue)).isNotNull();
    }

    @DisplayName("잘못된 문자열로 객체 생성 시도 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void createFailTest(String invalidValue) {
        assertThatThrownBy(() -> new Name(invalidValue))
                .isInstanceOf(InvalidNameException.class);
    }
}
