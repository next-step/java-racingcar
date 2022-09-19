package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Nested
    @DisplayName("요구사항1")
    class Requirement1 {

        @Test
        @DisplayName("쉼표가_포함된_문자열을_쉼표를_기준으로_분리_시_순서_유지되어_분리")
        void req1Test() {
            String str = "1,2";

            String[] result = str.split(",");

            assertThat(result.length).isEqualTo(2);
            assertThat(result).containsExactly("1", "2");
        }
    }

    @Nested
    @DisplayName("요구사항2")
    class Requirement2 {

        @Test
        @DisplayName("괄호가_포함된_문자열_괄호제거_시_괄호_안의_문자열만_남김")
        void req2Test() {
            String str = "(1,2)";

            str = str.substring(1);
            str = str.substring(0, str.length() - 1);

            assertThat(str).isEqualTo("1,2");
        }
    }

    @Nested
    @DisplayName("요구사항3")
    class Requirement3 {

        @Test
        @DisplayName("인덱스_범위를_넘어가지_않는_특정_위치_문자_확인_시_해당_위치_문자_반환")
        void req3Test1() {
            String str = "abc";

            char c = str.charAt(0);

            assertThat(c).isEqualTo('a');
        }

        @Test
        @DisplayName("인덱스_범위를_넘어가는_특정_위치_문자_확인_시_StringIndexOutOfBoundsException_발생")
        void req3Test2() {
            String str = "abc";

            int index = 5;

            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                    .isThrownBy(() -> str.charAt(index))
                    .withFailMessage(String.format("Index: %d, Size: %d", index, str.length()));
        }
    }

}
