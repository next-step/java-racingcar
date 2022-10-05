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
    @ValueSource(strings = {"a", "ab", "abcde"})
    void Given_Name_LessThanEquals_5_When_InitCar_Then_Created(String name) {
        assertThatNoException().isThrownBy(() -> Car.init(name));
    }

    @Test
    void Given_StringLength_Gte_5_When_CreateCarName_Then_Fail() {
        assertThatThrownBy(() -> new CarName("abcdef")).isInstanceOf(ExceedLengthException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void Given_BlankName_When_InitCar_Then_Fail(String name) {
        assertThatThrownBy(() -> Car.init(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
