package step3.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringSpliterTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "a|b", "a,", ",", ",a", "a,b,c"})
    void Given_AnyString_When_Split_Then_Success(String string) {
        assertThatNoException().isThrownBy(() -> StringSpliter.split(string));
    }
}
