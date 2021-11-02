import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("1,2 가 들어왔을 때 1과 2로 분리되어 리턴")
    public void splitOfCommaValue(){
        String commaValue = "1,2";
        String[] splitResult = commaValue.split(",");
        Assertions.assertThat(splitResult).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1 이 들어왔을 때 1만을 포함하는 배열로 리턴")
    public void splitOfOneLengthString() {
        String oneLengthValue = "1";
        String[] splitResult = oneLengthValue.split(",");
        Assertions.assertThat(splitResult).contains("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 괄호를 제거하여 리턴")
    public void withoutParenthesesOfString() {
        String withParentheses = "(1,2)";
        int openParentheses  = 1;
        int closeParentheses = 4;
        String substring = withParentheses.substring(openParentheses, closeParentheses);
        Assertions.assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 로 charAt() 함수를 사용할 때 입력 값이 정상일 경우 정상 수행")
    public void inputValueIsWithinNormalRange() {
        String inputValue = "abc";
        char extractedCharacter = inputValue.charAt(1);
        Assertions.assertThat(extractedCharacter).isEqualTo('b');
    }

    @Test
    @DisplayName("abc 로 charAt() 함수를 사용할 때 입력 값이 검색 범위를 넘어가면 StringIndexOutOfBoundsException 발생")
    public void rangeOfInputValueExceedsTheNormalRange() {
        String inputValue = "abc";
        Assertions.assertThatThrownBy(() -> inputValue.charAt(3))
                  .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
