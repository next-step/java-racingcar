package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Step1 : String 클래스 테스트")
public class StringTest {
    @Test
    @DisplayName("요구사항 1 : 구분자를 가지고 있는 문자열에 대한 split 테스트")
    public void splitStringHasDelimiterTest() {
        String givenData = "1,2";

        String[] result = givenData.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 1 : 구분자를 가지고 있지 않은 문자열에 대한 split 테스트")
    public void splitStringHasNotDelimiterTest() {
        String givenData = "1";

        String[] result = givenData.split(",");

        assertThat(result).containsOnly("1");
    }

    @Test
    @DisplayName("요구사항 2 : 괄호 제거 테스트")
    public void deleteBracketTest() {
        String givenData = "(1,2)";

        String result = givenData.substring(1, givenData.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 : 특정 위치의 문자열 추출 테스트")
    public void extractSpecificIndexWordTest() {
        String givenData = "abc";

        char result = givenData.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("요구사항 3 : 범위 외의 문자열 참조 시 Exception 발생 테스트")
    public void throwExceptionAccessOutOfIndexTest() {
        String givenData = "abc";
        assertThatThrownBy(() -> {
            givenData.charAt(givenData.length() + 1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
