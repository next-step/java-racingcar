package me.devyonghee.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class NameTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> Name.from("a"));
        assertThatNoException().isThrownBy(() -> Name.from("12345"));
    }

    @ParameterizedTest
    @DisplayName("반드시 문자가 존재해야 함")
    @NullAndEmptySource
    void instance_blank_thrownIllegalArgumentException(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Name.from(name));
    }

    @Test
    @DisplayName("5자 이하의 이름만 가능")
    void instance_overFiveLength_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Name.from("123456"));
    }
}
