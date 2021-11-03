import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @ValueSource(strings = "1,2")
    @ParameterizedTest(name = "\"1,2\"을 ,로 split 했을 때 1과 2가 반환된다.")
    void splitTest(String input) {
        String[] arr = input.split(",");

        assertThat(arr).containsExactly("1", "2");
    }


    @ValueSource(strings = "1")
    @ParameterizedTest(name = "\"1\"을 ,로 split 했을 때 1만을 포함한 배열이 반환된다.")
    void singleSplitTest(String input) {
        String[] arr = input.split(",");

        assertThat(arr).containsExactly("1");
    }

    @ValueSource(strings = "(1,2)")
    @ParameterizedTest(name = "\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환한다.")
    void subStringTest(String input) {
        String subString = input.substring(1, input.length() - 1);

        assertThat(subString).isEqualTo("1,2");
    }

}
