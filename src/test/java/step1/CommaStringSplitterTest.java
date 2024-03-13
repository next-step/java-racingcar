package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName(",로 이루어진 문자열 split 테스트")
public class CommaStringSplitterTest {

    @Test
    @DisplayName(",로 구분된 문자열을 문자열 배열로 반환한다.")
    public void shouldReturnStringArray_givenCommaSeparatedSting(){
        String input = "1,2";
        String[] output = CommaStringSplitter.split(input);
        String[] expectedOutput = new String[]{"1","2"};

        assertThat(output).containsExactly(expectedOutput);
    }

    @Test
    @DisplayName(",가 없는 문자열을 값이 1개인 문자열 배열로 반환한다.")
    public void shouldReturnStringArray_givenNotCommaSeparatedString(){
        String input = "1";
        String[] output = CommaStringSplitter.split(input);
        String[] expectedOutput = new String[]{"1"};

        assertThat(output).containsExactly(expectedOutput);
    }
    @Test
    @DisplayName("(로 시작하고 )로 끝나는 ,로 구분된 문자열을 ()를 제외한 문자열 배열로 반환한다.")
    public void shouldReturnExcludedParenthesisStringArray_givenIncludingParenthesisCommaSeparatedString(){
        String input = "(1,2)";
        String[] output = CommaStringSplitter.split(input);
        String[] expectedOutput = new String[]{"1","2"};

        assertThat(output).containsExactly(expectedOutput);
    }



}
