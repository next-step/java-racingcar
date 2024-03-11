package step1remind1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.catchThrowable;

public class StringTest {
    @Test
    @DisplayName("요구사항1 - " +
            " [1] \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는가? " +
            " [2] \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지")
    public void split() {
        String[] input = "1".split(",");
        Assertions.assertThat(input).contains("1");
        input = "1,2".split(",");
        Assertions.assertThat(input).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항2 - " +
            "\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    public void substring() {
        String input = "(1,2)";
        Assertions.assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - " +
            "\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트" +
            "String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현" +
            "JUnit의 @DisplayName을 활용")
    public void charAt()
    {
        String input = "abc";
        assertThatThrownBy(() -> { input.charAt(3); }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
