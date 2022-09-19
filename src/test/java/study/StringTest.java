package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split(){
        String[] data = "1,2".split(",");
        Assertions.assertThat(data).contains("1");
        Assertions.assertThat(data).containsExactly("1","2");
    }

    @Test
    void subString(){
        String result = "(1,2)".substring(1,4);
        Assertions.assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기")
    void charAtException(){
        String result = "abc";
        assertThatThrownBy(() -> {result.charAt(4);}).isInstanceOf(StringIndexOutOfBoundsException.class) .hasMessageContaining("String index out of range: 4");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {result.charAt(4);}).withMessageMatching("String index out of range: 4");
    }
}
