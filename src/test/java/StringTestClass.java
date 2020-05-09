import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringTestClass {

    private final String SPLIT_REGEX_STRING = ",";

    @DisplayName(",를 포함한 1,2을 ,로 split 했을 때 1과 2로 잘 분리 되는지 확인")
    @Test
    public void splitStringContainCommaTest() {
        String givenString = "1,2";

        String[] resultString = givenString.split(SPLIT_REGEX_STRING);

        Assertions.assertThat(resultString).containsExactly("1","2");
    }

    @DisplayName(",가 없는 1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는 지 테스트")
    @Test
    public void splitStringNotContainCommaTest() {
        String givenString = "1";

        String[] resultString = givenString.split(SPLIT_REGEX_STRING);

        Assertions.assertThat(resultString).containsExactly("1");
    }

    @DisplayName("주어진 문자열 abc 의 length 내에서 chartAt 할 때 정상적으로 char 를 가져오는 지 테스트")
    @Test
    public void charAtTest() {
        String givenString = "abc";

        char[] pickChars = new char[givenString.length()];
        for(int i = 0 ; i < givenString.length() ; i++) {
            pickChars[i] = givenString.charAt(i);
        }

        Assertions.assertThat(pickChars[0]).isEqualTo('a');
        Assertions.assertThat(pickChars[1]).isEqualTo('b');
        Assertions.assertThat(pickChars[2]).isEqualTo('c');
    }

    @DisplayName("주어진 문자열 abc 의 length를 벗어나서 charAt 할 때 StringIndexOutOfBoundsException 발생하는 지 테스트")
    @Test
    public void charAtIndexOutOfBoundsTest() {
        String givenString = "abc";

        Throwable thrown = catchThrowable(() -> {
            char pickChar = givenString.charAt(givenString.length() + 1);
        });

        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d");
    }

}
