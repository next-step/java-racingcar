
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @Test
    void splitStringToArray() {
        String digitLikeStrings = "1,2";
        String[] strings = digitLikeStrings.split(",");

        assertThat(strings).containsExactly("1", "2");
    }

    @Test
    void splitSingleString() {
        String digitLikeStrings = "1";
        String[] strings = digitLikeStrings.split(",");

        assertThat(strings).containsExactly("1");
    }

    @Test
    void substring() {
        String someString = "(1,2)";
        String extractedString = someString.substring(1, 4);

        assertThat(extractedString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt 메서드로 특정 위치의 문자 가져오기")
    void getStringWithCharAt() {
        String someString = "abc";

        assertThat(someString.charAt(0)).isEqualTo('a');
        assertThat(someString.charAt(1)).isEqualTo('b');
        assertThat(someString.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("음수 인덱스로 chatAt 실행 시 에러 발생")
    void chatAtWithNegativeIndex() {
        String someString = "abc";
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            someString.charAt(-1);
        });
    }

    @Test
    @DisplayName("문자열 길이보다 더 큰 인덱스로 chatAt 실행 시 에러 발생")
    void chatAtWithIndexGreaterThanStringLength() {
        String someString = "abc";
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            someString.charAt(someString.length() + 1);
        });
    }
}
