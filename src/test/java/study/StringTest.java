package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @Test
    @DisplayName("문자열 컴마 split 테스트")
    void stringSplitByCommaTest(){
        String[] splitOne = "1,2".split(",");
        String[] splitTwo = "1".split(",");
        assertThat(splitOne).containsExactly("1","2");
        assertThat(splitTwo).contains("1");
    }

    @Test
    @DisplayName("substring 괄호 제거 후 비교 테스트")
    void substringTest(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2})
    @DisplayName("charAt 특정 위치의 문자를 가져오는 기능")
    void charAtTest(int index){
        String value = "abc";
        assertThat(value.charAt(index)).isEqualTo(value.toCharArray()[index]);
    }

    @Test
    @DisplayName("charAt index가 넘어가면 IndexOutOfBoundsException 에러 발생")
    void exceptionTest(){
        String value = "abc";
        int index = value.length() + 1;
        assertThatThrownBy(() -> {
            value.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 4");
    }
}
