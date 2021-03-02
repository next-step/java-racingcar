package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("[요구사항1]1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    public void splitTest_1() {
        // given
        String str = "1,2";
        // when
        String[] result = str.split(",");
        // then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("[요구사항1]1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    @Test
    public void splitTest_2() {
        // given
        String str = "1";
        // when
        String[] result = str.split(",");
        // then
        assertThat(result).contains("1");
    }

    @DisplayName("[요구사항2]substring 활용 괄호를 제거하고 원하는 값이 반환되는지 확인")
    @Test
    public void substringTest() {
        // given
        String str = "(1,2)";
        // when
        String result = str.substring(1, str.length() - 1);
        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("[요구사항3]charAt() 메소드를 활용해 특정 위치의 문자 획득 확인")
    @Test
    public void chartAtTest_1() {
        // given
        String str = "abc";
        // when
        String result = String.valueOf(str.charAt(0));
        // then
        assertThat(result).isEqualTo("a");
    }

    @DisplayName("[요구사항3]charAt() 메소드 사용시 범위 초과된 문자 가져올시 StringIndexOutOfBoundsException 발생 확인")
    @Test
    public void chartAtTest_2() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

    @DisplayName("[요구사항3]charAt() 메소드 사용시 범위 초과된 문자 가져올시 StringIndexOutOfBoundsException 발생 확인")
    @Test
    public void chartAtTest_3() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageMatching("String index out of range: 3");
    }
}
