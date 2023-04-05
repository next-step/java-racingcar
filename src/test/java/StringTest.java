import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    /**
     * 요구사항 1 - 1
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     */
    @Test
    @DisplayName("\"1,2\"을 ,로 split 하다.")
    void splitTest1() {
        // Given
        String string = "1,2";

        // When
        String[] result = string.split(",");

        // Then
        assertThat(result).containsExactly("1", "2");
    }

    /**
     * 요구사항 1 -2
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    @DisplayName("\"1\"을 ,로 split 하다.")
    void splitTest2() {
        // Given
        String string = "1";

        // When
        String[] result = string.split(",");

        // Then
        assertThat(result).containsExactly("1");
    }

    /**
     * 요구사항 2
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    @DisplayName("\"(1,2)\" 문자열을 substring() 을 사용해 \"1,2\"로 만들다.")
    void substringTest() {
        // Given
        String string = "(1,2)";

        // When
        String result = string.substring(1, 4);

        // Then
        assertThat(result).isEqualTo("1,2");
    }


    /**
     * 요구사항 3 - 1
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("\"abc\" 문자열에 charAt() 메소드를 사용하다.")
    void charAtTest1() {
        // Given
        String string = "abc";

        // When
        char a = string.charAt(0);
        char b = string.charAt(1);
        char c = string.charAt(2);

        // Then
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    /**
     * 요구사항 3 - 2
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     */
    @Test
    @DisplayName("charAt() 을 사용할 때, 인덱스에서 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAtTest2() {
        // Given
        String string = "abc";

        // When Then
        assertThatThrownBy(() -> {
            char result = string.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
