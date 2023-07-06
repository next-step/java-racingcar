package car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 경우 예외를 던진다.")
    void test1() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Name("qwerty"));
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하여야 한다.")
    void test2() {
        Assertions.assertThatNoException().isThrownBy(() -> new Name("abcde"));
    }
}
