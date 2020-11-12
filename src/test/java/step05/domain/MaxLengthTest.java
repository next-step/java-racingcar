package step05.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxLengthTest {

    private static Stream<Arguments> provideNameMaxLengthResult() {
        return Stream.of(
                Arguments.of("1234", "3", false),
                Arguments.of("1234", "4", true),
                Arguments.of("1234", "5", true)
        );
    }

    @DisplayName("이름의 maxLength 테스트")
    @ParameterizedTest
    @MethodSource("provideNameMaxLengthResult")
    public void test_isInBoundLength(String name, int maxLength, boolean expect) {
        MaxLength testObj = MaxLength.of(maxLength);
        boolean result = testObj.isInBoundLength(name);
        assertThat(result).isEqualTo(expect);
    }

    private static Stream<Arguments> provideDefaultMaxLengthResult() {
        return Stream.of(
                Arguments.of("1234", true),
                Arguments.of("12345", true),
                Arguments.of("1234567", false)
        );
    }

    @DisplayName("이름의 Default maxLength 테스트")
    @ParameterizedTest
    @MethodSource("provideDefaultMaxLengthResult")
    public void test_isInBoundDefaultLength(String name, boolean expect) {
        MaxLength testObj = MaxLength.of();
        boolean result = testObj.isInBoundLength(name);
        assertThat(result).isEqualTo(expect);
    }

}
