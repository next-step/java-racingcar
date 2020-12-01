package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    @Test
    void splitDouble() {
        // given
        String input = "1,2";
        String delimiter = ",";

        // when
        String[] splitInput = input.split(delimiter);

        // then
        assertThat(splitInput).contains("1", "2");
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    @Test
    void splitSingle() {
        // given
        String input = "1";
        String delimiter = ",";

        // when
        String[] splitInput = input.split(delimiter);

        // then
        assertThat(splitInput).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    @Test
    void substring() {
        // given
        String input = "(1,2)";

        // when
        String substringInput = input.substring(1, input.length() - 1);

        // then
        assertThat(substringInput).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    void charAt(int index, char expected) {
        // given
        String input = "abc";

        // when
        char charAt = input.charAt(index);

        // then
        assertThat(charAt).isEqualTo(expected);
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    @Test
    void chartAtOutOfBound() {
        // given
        String input = "abc";
        int overIndex = input.length() + 1;

        // when / then
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            char ignored = input.charAt(overIndex);
        },"String index out of range: " + overIndex);
    }
}
