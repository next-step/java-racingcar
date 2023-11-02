import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

        @Test
        @DisplayName("한개의_숫자_문자열_스플릿")
        void 한개의_숫자_문자열_스플릿() {

                // given
                String[] commaSeparatedNumbers = "1".split(",");

                // when
                // then
                assertThat(commaSeparatedNumbers).contains("1");
        }

        @Test
        @DisplayName("여러개의_숫자_문자열_스플릿")
        void 여러개의_숫자_문자열_스플릿() {

                // given
                String[] commaSeparatedNumbers = "1,2".split(",");

                // when
                // then
                assertThat(commaSeparatedNumbers).containsExactly("1", "2");
        }

        @Test
        @DisplayName("숫자_문자열_괄호_제거")
        void 숫자_문자열_괄호_제거() {

                // given
                String parenthesizedValue = "(1,2)";

                // when
                String result = parenthesizedValue.substring(1, parenthesizedValue.length() - 1);

                // then
                assertEquals(result, "1,2");
        }

        @Test
        @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어날 경우 에러")
        void 특정_위치의_문자_가져오기() {

                // given
                String value = "abc";
                int idx = 3;

                // when
                // then
                assertThatExceptionOfType(IndexOutOfBoundsException.class)
                    .isThrownBy(() -> {
                            value.charAt(idx);
                    }).withMessageMatching("String index out of range: 3");
        }
}