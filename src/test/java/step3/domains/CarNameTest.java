package step3.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.ExceedLengthException;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abcde", " aaaaa "})
    void Given_Name_LessThanEquals_5_When_InitCar_Then_Created(String name) {
        assertThatNoException().isThrownBy(() -> new CarName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abc de", " abc de "})
    void Given_StringLength_Gte_5_When_CreateCarName_Then_Fail(String name) {
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(ExceedLengthException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void Given_BlankName_When_InitCar_Then_Fail(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
