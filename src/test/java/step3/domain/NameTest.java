package step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * 자동차 이름 관련 테스트 코드
 */
class NameTest {

    private static Stream<Arguments> invalidEntry() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of("", false),
                Arguments.of(" ", false),
                Arguments.of("aaaaaa", false)

        );
    }

    @ParameterizedTest(name = "자동차 이름 설정 {0} -> 동등성, 동일성 테스트")
    @CsvSource(value = {"user", "user1"})
    void equalsNameTest(final String given) {
        // given
        Name name = new Name(given);
        // when
        Name expected = new Name(given);
        // then
        assertThat(name).isEqualTo(expected);
        assertThat(name.hashCode()).isEqualTo(expected.hashCode());
    }

    @ParameterizedTest(name = "{0} 이름 설정 시 예외 발생 테스트")
    @MethodSource(value = "invalidEntry")
    void exceptionNameTest(final String given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(given));
    }
}
