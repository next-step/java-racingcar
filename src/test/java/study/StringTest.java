package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    @DisplayName("Test String split method")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        //배열의 순서까지 파악 가능
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("Test String substring method")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    @DisplayName("Test String charAt method")
    void charAt(int idx) {
        String string = "abc";
        //예외처리에 대한 테스트, 익명 함수 안에 구현한 코드가 예상되는 Exception 을 발생시키는지 테스트
        //hasMessageContaining : 발생한 Exception 메세지가 파라미터 값을 포함하는지 테스트
        assertThatThrownBy(() -> string.charAt(idx))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + idx);

        //withMessageMatching : 발생한 Exception 메세지가 파라미터 값과 정규식으로 매칭되는지 테스트
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> string.charAt(idx)).withMessageMatching(".+index.+\\d+");
    }
}
