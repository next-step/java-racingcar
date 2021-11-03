import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @ValueSource(strings = "1,2")
    @ParameterizedTest(name = "{arguments}을 ,로 split 했을 때 1과 2가 반환된다.")

    void splitTest(String input) {
        String[] arr = input.split(",");

        assertThat(arr).containsExactly("1", "2");
    }


    @ValueSource(strings = "1")
    @ParameterizedTest(name = "{arguments}을 ,로 split 했을 때 1만을 포함한 배열이 반환된다.")
    void singleSplitTest(String input) {
        String[] arr = input.split(",");

        assertThat(arr).containsExactly("1");
    }

    @ValueSource(strings = "(1,2)")
    @ParameterizedTest(name = "{arguments} 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환한다.")
    void subStringTest(String input) {
        String subString = input.substring(1, input.length() - 1);

        assertThat(subString).isEqualTo("1,2");
    }

    @ValueSource(strings = "abc")
    @ParameterizedTest(name = "{arguments} 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자와 일치한다.")
    void charAtTest(String input) {
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }


    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @SuppressWarnings({"ResultOfMethodCallIgnored", "LambdaBodyCanBeCodeBlock"})
    void stringIndexOutOfBoundsExceptionTest() {
        String input = "abc";

        int outOfIndex = input.length();

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> input.charAt(outOfIndex));
    }


}
