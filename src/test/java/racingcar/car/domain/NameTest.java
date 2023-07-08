package racingcar.car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 경우 예외를 던진다.")
    void name_givenOver5Length_throwException() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name("qwerty"));
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하여야 한다.")
    void name_givenBelowThan5Length_doesNotThrowException() {
        Assertions.assertThatNoException()
            .isThrownBy(() -> new Name("abcde"));
    }
}
