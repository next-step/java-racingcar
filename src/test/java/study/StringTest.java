package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("(\"1,2\")을 콤마로 분리한 결과 확인")
    void stringMultipleSplit() {
        String[] data = "1,2".split(",");
        assertThat(data).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 콤마로 분리한 결과 확인")
    void stringSingleSplit() {
        String[] data = "1".split(",");
        assertThat(data).contains("1");
    }

    @Test
    @DisplayName("substring() 메소드 사용하기")
    void substringMethodUsing() {
        String str = "(1,2)";
        assertThat(str.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 사용하기")
    void charAtMethodUsing() {
        String str = "abc";
        assertThat(str.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열 범위를 벗어난 charAt() 메소드 예외처리")
    void charAtMethodException() {
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
