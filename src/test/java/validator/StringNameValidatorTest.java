package validator;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringNameValidatorTest {

    @Test
    @DisplayName("모든 이름은 5자 이하여야 한다.")
    void test1() {
        assertThatNoException().isThrownBy(() -> StringNameValidator.validate("crong"));
    }

    @Test
    @DisplayName("이름 길이가 5자를 초과하면 예외를 발생한다.")
    void test2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringNameValidator.validate("baemincheesic"));
    }
}
