package learningTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {
    @Test
    @DisplayName("','를 이용하여 String을 split 한다.")
    void test_requirement_1_1() {
        String input = "1,2";

        String[] result = input.split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("하나의 숫자를 ','로 split 할 때, 그 숫자가 그래도 나오는지 확인한다.")
    void test_requirement_1_2() {
        String input = "1";

        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("'()'를 제거한다.")
    void test_requirement_2() {
        String input = "(1,2)";
        String expecting = "1,2";

        String result = input.replace("(", "").replace(")", "");
        assertThat(result).isEqualTo(expecting);
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다")
    void test_requirement_3_1() {
        String input = "abc";
        char expecting = 'b';

        char result = input.charAt(1);
        assertThat(expecting).isEqualTo(result);
    }

    @Test
    @DisplayName("위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void test_requirement_3_2() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(input.length())).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
