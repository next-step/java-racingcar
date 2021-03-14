import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("1,2를 split 했을 떄 1과 2로 잘 분리 되었는지 확인")
    public void 요구사항_1() {
        String text = "1,2";
        String[] result = text.split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("(1,2)를 ()를 제거하고 1,2로 잘 반환하는지 확인")
    public void 요구사항_2() {
        String text = "(1,2)";
        String result = text.substring(1,4);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("abc 를 chatAt() 했을때 특정 위치의 문자열을 제대로 가져오는지, 위 값을 벗어날 경우 특정 예외 처리 잘 되는지 확인)")
    public void 요구사항_3() {
        String text = "abc";
        assertThat(text.charAt(0)).isEqualTo('a');
        assertThat(text.charAt(1)).isEqualTo('b');
        assertThat(text.charAt(2)).isEqualTo('c');
        // 예외가 발생했을때를 어떻게 처리하지 ? try catch? 컴퓨터 적으로 저 문구를 어떻게 해석하지 ?
        assertThatThrownBy(() -> { text.charAt(3); }).isInstanceOf(StringIndexOutOfBoundsException.class)
                                                     .hasMessageContaining("String index out of range: 3");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> { text.charAt(3); })
                                                                        .withMessageContaining("String index out of range: 3");
    }
}
