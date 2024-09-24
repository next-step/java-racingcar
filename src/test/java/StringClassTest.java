import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringClassTest {
    @Test
    void splitTest() {
        final String input1 = "1,2";

        String[] split1 = input1.split(",");
        Assertions.assertThat(split1).containsExactly("1", "2");

        final String input2 = "1";
        String[] split2 = input2.split(",");
        Assertions.assertThat(split2).containsExactly("1");
    }

    @Test
    void substringTest() {
        final String input = "(1,2)";
        String substring = input.substring(1, 4);
        Assertions.assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드 테스트")
    void charAtTest() {
        final String input = "abc";

        for (int i = 0; i < 3; i++) {
            char ch = input.charAt(i);
            int idx = input.indexOf(ch);
            Assertions.assertThat(idx).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("charAt 메소드 테스트 - 인덱스 범위 벗어났을때 에러 테스트")
    void charAtTest_IndexOutOfBoundsException() {
        final String input = "abc";
        int testIdx = input.length();

        Assertions.assertThatThrownBy(() -> {
                    char ch = input.charAt(testIdx);
                }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }
}
