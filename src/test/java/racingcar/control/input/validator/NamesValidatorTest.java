package racingcar.control.input.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

class NamesValidatorTest {
    private final NamesValidator validator = new NamesValidator();


    @Test
    @DisplayName("이름이 5글자 이상이면 예외가 나야한다")
    public void verifyLength() {
        List<String> names = List.of("123456");

        Assertions.assertThatThrownBy(() -> validator.verify(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 없거나 null이면 예외가 나야 한다")
    public void verify(List<String> input) {
        Assertions.assertThatThrownBy(() -> validator.verify(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}