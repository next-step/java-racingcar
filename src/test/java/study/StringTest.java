package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @DisplayName("split 했을 때 잘 분리되는지 확인하는 테스트")
    @Test
    void splitTest() {
        // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현
        String target = "1,2";
        String[] result = target.split(",");
        assertThat(result).containsExactly("1", "2");

        // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현
        target = "1";
        result = target.split(",");
        assertThat(result).containsExactly("1");
    }


    @DisplayName("(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현하는 테스트")
    @Test
    void substringTest() {
        String target = "(1,2)";
        String result = target.substring(1, target.length() - 1);

        assertEquals(result, "1,2");
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 테스트")
    @Test
    void charAtExceptionTest() {
        String target = "abc";
        int index = target.length();

        assertThatThrownBy(() -> {
            char c = target.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessage("String index out of range: " + index);
    }
}
