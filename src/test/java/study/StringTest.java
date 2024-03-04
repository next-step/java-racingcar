package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void testSplit() {
        String input = "1,2";
        String[] result =  input.split(",");

        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void testSubstring() {
        String input = "(1,2)";
        String result = input.substring(1).substring(0, 3);

        assertThat(result).isEqualTo("1,2");
    }

    @Nested
    @DisplayName("chartAt() 테스트")
    class ChartAtTest {
        @Test
        @DisplayName("charAt()에 위치값을 전달하여 문자열에서 특정 위치의 문자를 가져올 수 있다.")
        void testChartAt() {
            String input = "abc";
            int index = 0;

            Character selectedChar = input.charAt(index);

            assertThat(selectedChar).isEqualTo('a');
        }

        @Test
        @DisplayName("chartAt()에 잘못된 위치값을 전달하는 경우 StringIndexOutOfBoundsException 이 발생한다.")
        void testChartAtWrongIndex() {
            String input = "abc";
            int wrongIndex = input.length() + 100;

            assertThatThrownBy(() -> input.charAt(wrongIndex)).
                    isInstanceOf(StringIndexOutOfBoundsException.class);
        }
    }
}
