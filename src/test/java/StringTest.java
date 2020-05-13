import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    void multi_value_split() {
        String input = "1,2";
        assertThat(input.split(",")).contains("1", "2")
                .containsExactly("1","2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    void single_value_split() {
        String input = "1";
        assertThat(input.split(",")).contains("1")
                .containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하는 학습 테스트")
    void substring() {
        String input = "(1,2)";
        assertThat(input.substring(input.indexOf('(')+1, input.indexOf(')'))).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    void charAt() {
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }
}
