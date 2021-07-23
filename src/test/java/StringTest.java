import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @ParameterizedTest
    @DisplayName("1,2를 ','로 split 했을 때 1과 2로 잘 분리 되는지 확인한다")
    @ValueSource(strings = "1,2")
    void demandOne(String input) {
        String[] actual = input.split(",");

        assertThat(actual).contains("1", "2")
                .containsExactly("1", "2");
    }

    @ParameterizedTest
    @DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환하도록 구현한다.")
    @ValueSource(strings = "(1,2)")
    void demandTwo(String input) {
        String actual = input.substring(1, 4);

        assertThat(actual).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    @CsvSource({"abc,a,0", "abc,b,1", "abc,c,2"})
    void demandThree1(String input, char expected, int idx) {
        char actual = input.charAt(idx);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    @CsvSource({"abc,4"})
    void demandThree2(String input, int idx) {
        assertThatThrownBy(() -> input.charAt(idx))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
