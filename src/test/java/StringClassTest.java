import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StringClassTest {

    @Nested
    class 요구_사항_1 {
        @Test
        void split_했을_때_1과_2로_분리() {
            //given
            String test = "1,2";

            //when
            String[] result = test.split(",");

            //then
            assertThat(result).contains("1", "2");
            assertThat(result).containsExactly("1", "2");
        }

        @Test
        void split_했을_때_1만_포함() {
            //given
            String test = "1";

            //when
            String[] result = test.split(",");

            //then
            assertThat(result).contains("1");
            assertThat(result).containsExactly("1");
        }
    }

    @Nested
    class 요구_사항_2 {
        @Test
        void substring_으로_괄호_제거() {
            //given
            String test = "(1,2)";

            //when
            String result = test.substring(1, test.length() - 1);

            //then
            assertThat(result).isEqualTo("1,2");
        }
    }

    @Nested
    class 요구_사항_3 {
        @DisplayName("chatAt 을 통해 특정 위치의 문자를 성공적으로 가져온다.")
        @Test
        void charAt_했을_때_특정_위치_문자_가져오기_성공() {
            //given
            String test = "abc";

            //when
            char testChar = test.charAt(1);

            //then
            assertThat(testChar).isEqualTo('b');
        }

        @DisplayName("chatAt 을 통해 특정 위치의 문자 가져올 때 위치 값이 벗어나 에러가 발생한다.")
        @Test
        void charAt_했을_때_특정_위치_문자_가져오기_실패() {
            //given
            String test = "abc";

            //when, then
            assertThatThrownBy(() -> test.charAt(3))
                    .isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: 3");
        }
    }
}
