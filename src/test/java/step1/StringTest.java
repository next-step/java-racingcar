package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringTest {

    @Nested
    @DisplayName("요구사항 1 split 테스트")
    class step1 {
        @Test
        @DisplayName("1,2을 ','로 split 했을 때 1과 2로 잘 분리 되는지 확인 할 수 있다.")
        void splitStrings() {
            String beforeSplit = "1,2";
            String[] afterSplit = beforeSplit.split(",");

            assertThat(afterSplit).contains("1","2");
            assertThat(afterSplit).containsExactly("1","2");
        }

        @Test
        @DisplayName("1을 ',' 로 split 했을 때 1만을 포함하는 배열이 반환 된다.")
        void splitStringOne() {
            String beforeSplit = "1";
            String[] afterSplit = beforeSplit.split(",");

            assertThat(afterSplit).contains("1");
            assertThat(afterSplit).containsExactly("1");
        }
    }

    @Nested
    @DisplayName("요구사항 2 subString 테스트")
    class step2 {

        @Test
        @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2 를 반환 한다.")
        void subStringTest() {
            String beforeString = "(1,2)";
            String afterString = beforeString.substring(1,4);

            assertThat(afterString).isEqualTo("1,2");
        }
    }

    @Nested
    @DisplayName("요구사항 3 charAt 테스트")
    class step3 {

        @Test
        @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 수 있다.")
        void charAtTest() {
            String testString = "abc";

            char c = testString.charAt(0);

            assertThat(c).isEqualTo('a');
        }

        @Test
        @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
        void charAtExceptionTest() {
            String testString = "abc";

            assertThatThrownBy(() -> {
                testString.charAt(testString.length() + 1);
            }).isInstanceOf(StringIndexOutOfBoundsException.class);
        }
    }
}
