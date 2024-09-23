import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static constants.AlphabetCharacter.A;
import static constants.AlphabetCharacter.B;
import static constants.AlphabetCharacter.C;
import static constants.NumberCharacter.ONE;
import static constants.NumberCharacter.TWO;
import static constants.SpecialCharacter.CLOSE_PARENTHESIS;
import static constants.SpecialCharacter.COMMA;
import static constants.SpecialCharacter.OPEN_PARENTHESIS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DisplayName("String")
class StringTest {

    private static final String NUMBERS_WITH_COMMA = ONE + COMMA + TWO;
    private static final String ALPHABETS = String.valueOf(A) + B + C;

    @Nested
    @DisplayName("split()")
    class SplitTest {

        @Test
        @DisplayName("\"1,2\" 문자열을 \",\" 구분자로 하여 split 함수를 사용하면 1과 2로 분리된다.")
        void test01() {
            // when
            final var numbers = NUMBERS_WITH_COMMA.split(COMMA);

            // then
            assertThat(numbers).containsExactly(ONE, TWO);
        }

        @Test
        @DisplayName("\"1\" 문자열을 \",\" 구분자로 하여 split 함수를 사용하면 1만 반환된다.")
        void test02() {
            // when
            final var numbers = ONE.split(COMMA);

            // then
            assertThat(numbers).containsExactly(ONE);
        }

    }

    @Nested
    @DisplayName("substring()")
    class SubstringTest {

        @Test
        @DisplayName("\"(1,2)\" 문자열을 substring 함수를 활용해 \"()\"을 제거하면 \"1,2\"가 반환된다.")
        void test01() {
            // given
            final var 괄호로_쌓인_숫자 = OPEN_PARENTHESIS + NUMBERS_WITH_COMMA + CLOSE_PARENTHESIS;

            // when
            final var 여는_괄호_위치 = 괄호로_쌓인_숫자.indexOf(OPEN_PARENTHESIS);
            final var 닫는_괄호_위치 = 괄호로_쌓인_숫자.indexOf(CLOSE_PARENTHESIS);
            final var numbers = 괄호로_쌓인_숫자.substring(여는_괄호_위치 + 1, 닫는_괄호_위치);

            // then
            assertThat(numbers).isEqualTo(NUMBERS_WITH_COMMA);
        }

    }

    @Nested
    @DisplayName("charAt()")
    class CharAtTest {

        @Test
        @DisplayName("\"abc\" 문자열의 chatAt 함수 인자에 각각 위치 값을 주면 특정 위치의 문자를 반환한다")
        void test01() {
            // when
            final var 첫번째_위치의_문자 = ALPHABETS.charAt(0);
            final var 두번째_위치의_문자 = ALPHABETS.charAt(1);
            final var 세번째_위치의_문자 = ALPHABETS.charAt(2);

            // then
            assertSoftly(softly -> {
                softly.assertThat(첫번째_위치의_문자).isEqualTo(A);
                softly.assertThat(두번째_위치의_문자).isEqualTo(B);
                softly.assertThat(세번째_위치의_문자).isEqualTo(C);
            });
        }

        @Test
        @DisplayName("\"abc\" 문자열의 chatAt 함수 인자에 위치값을 벗어나면 예외가 발생한다.")
        void test02() {
            // given
            final var 올바르지_않은_인덱스 = ALPHABETS.length() + 5;

            // when & then
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                    .isThrownBy(() -> ALPHABETS.charAt(올바르지_않은_인덱스))
                    .withMessageMatching("String index out of range: \\d+");
        }

    }
}
