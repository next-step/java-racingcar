package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("split() 메소드_값이 잘 분리되는지 테스트")
    void splitTest01() {
        String data = "1,2";
        String[] result = data.split(",");
        // 결과확인
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split() 메소드_특정 값을 포함하는 배열 반환 테스트")
    void splitTest02() {
        String[] result = "1".split(",");
        // 결과확인
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메소드 테스트")
    void substringTest01() {
        String data = "(1,2)";
        String resData = data.substring(1,4);
        // 결과확인
        assertThat(resData).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드_특정 위치의 문자 반환 테스트")
    void charAtTest01() {
        String data = "abc";
        char resData1 = data.charAt(0);
        // 결과확인
        assertThat(resData1).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() 메소드_특정 위치의 문자값을 벗어난 경우, 예외 테스트")
    void charAtExceptionTest01() {
        String data = "abc";
        int testIdx = 3;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    char result = data.charAt(testIdx);
                }).withMessageMatching("String index out of range : \\d+");

    }
}
