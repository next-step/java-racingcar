import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("String 1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String 1을 ,로 split 했을 때 1만 포함하는 배열 반환 테스트")
    void splitOnly1() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }


    @Test
    @DisplayName("String (1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\" 반환하는 테스트")
    void substring() {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 문자 위치값이 벗어났을 때 StringIndexOutOfBoundsException 발생하는지 테스트")
    void charAt() {
        String data = "abc";
        assertThatThrownBy(() -> {
            data.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");

    }


}
