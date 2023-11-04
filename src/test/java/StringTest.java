import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

        @Test
        @DisplayName("한개의_숫자_문자열_스플릿")
        void 한개의_숫자_문자열_스플릿() {

                String[] commaSeparatedNumbers = "1".split(",");
                assertThat(commaSeparatedNumbers).contains("1");
        }

        @Test
        @DisplayName("여러개의_숫자_문자열_스플릿")
        void 여러개의_숫자_문자열_스플릿() {

                String[] commaSeparatedNumbers = "1,2".split(",");
                assertThat(commaSeparatedNumbers).containsExactly("1", "2");
        }

        @Test
        @DisplayName("숫자_문자열_괄호_제거")
        void 숫자_문자열_괄호_제거() {

                String parenthesizedValue = "(1,2)";
                String result = parenthesizedValue.substring(1, parenthesizedValue.length() - 1);
                assertThat(result).isEqualTo("1,2");
        }

        @Test
        @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어날 경우 에러")
        void 특정_위치의_문자_가져오기() {

                assertThatExceptionOfType(IndexOutOfBoundsException.class)
                    .isThrownBy(() -> {
                            "abc".charAt(3);
                    }).withMessageMatching("String index out of range: 3");
        }
}