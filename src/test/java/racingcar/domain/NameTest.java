package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @DisplayName("Null, empty, 공백, 길이 5자 초과시 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "accent"})
    void create_ThrowsIllegalArgumentException_IfNameIsNullOrEmptyOrBlankOrMoreThanFive(String name) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Name(name));
    }
}
