package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {

    private static final String SEPARATOR = ",";

    /**
     * 요구사항 1
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     * 힌트
     * 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
     * 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
     */

    @Nested
    @DisplayName("요구사항 1 - split")
    class Requirement01 {
        @Test
        @DisplayName("문자열 사이에 구분자가 있는 경우 정상적으로 분리가 된다")
        void split_학습_테스트_1() {
            // given
            final String input = "1,2";

            // when
            final String[] split = input.split(SEPARATOR);

            // then
            assertThat(split).contains("1", "2");
            assertThat(split).containsExactly("1", "2");
            assertThat(split).isEqualTo(new String[]{"1", "2"});
        }

        @Test
        @DisplayName("문자열 시작, 끝에 구분자가 있는 경우 빈 값으로 분리가 된다")
        void split_학습_테스트_2() {
            // given
            final String input = ",1,2";

            // when
            String[] split = input.split(SEPARATOR);

            // then
            assertThat(split).contains("1", "2");
            assertThat(split).containsExactly("", "1", "2");
            assertThat(split).isEqualTo(new String[]{"", "1", "2"});
        }

    }


    /**
     * 요구사항 2
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Nested
    @DisplayName("요구사항 2 - substring")
    class Requirement02 {

        @Test
        @DisplayName("substring으로 원하는 범위의 문자열 값만 가져올 수 있다")
        void substring_학습_테스트_1() {
            // given
            final String input = "(1,2)";

            // when
            final String substring = input.substring(1, input.length() - 1);

            // then
            assertThat(substring).isEqualTo("1,2");
        }
    }

    /**
     * 요구사항 3
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Nested
    @DisplayName("요구사항 3 - charAt")
    class Requirement03 {

        @Test
        @DisplayName("charAt 메서드 사용시 문자열 길이를 벗어나는 값을 입력하면 StringIndexOutOfBoundsException이 발생한다")
        void charAt_학습_테스트_1() {
            // given
            final String input = "abc";

            // when&then
            assertThatThrownBy(() -> input.charAt(999)).isInstanceOf(StringIndexOutOfBoundsException.class);
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> input.charAt(-5));
        }
    }


}
