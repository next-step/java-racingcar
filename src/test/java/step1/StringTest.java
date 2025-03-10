package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항 1 - [1,2]을 ,로 split 했을 때 1과 2로 잘 분리된다.")
    void splitTest() {
        String input = "1,2";

        String[] result = input.split(",");

        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 1.2. - [1]을 ,로 split 했을 때 1이 반환된다.")
    void splitTest2() {
        String input = "1";

        String[] result = input.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 - (1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환할 수 있다.")
    void substringTest() {
        String input = "(1,2)";

        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 - charAt() 메소드를 활용해 위치 값을 벗어나면 예외가 발생한다.")
    void chartAtTest() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
