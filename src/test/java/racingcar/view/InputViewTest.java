package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {
    @ParameterizedTest(name = "자동차 이름이 5자를 넘으면 false, 아니면 true를 반환한다.")
    @MethodSource("carNames")
    void testInputCarNames(String name, boolean expected) {
        // Given
        InputView inputView = new InputView();

        // When
        boolean actual = inputView.isValidName(name);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이름이 5자가 넘는 경우 IllegalArgumentException이 발생해야 한다")
    void testCheckNames() {
        // Given
        InputView inputView = new InputView();
        List<String> names = Arrays.asList("abcde,abcdefghi");

        // When && Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.checkNames(names));
    }

    static Stream<Arguments> carNames() {
        return Stream.of(
                Arguments.of("a", true),
                Arguments.of("ab", true),
                Arguments.of("abc", true),
                Arguments.of("abcd", true),
                Arguments.of("abcde", true),
                Arguments.of("abcdef", false)
        );
    }
}