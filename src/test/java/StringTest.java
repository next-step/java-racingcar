import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 자료형 관련 테스트")
public class StringTest {

    @DisplayName("콤마를 기준으로 숫자를 분리한다.")
    @Test
    void splitNumber() {
        // given
        String numberOneAndTwo = "1,2";
        String numberOne = "1";

        // then
        String[] splitOneAndTwoNumber = numberOneAndTwo.split(",");
        String[] splitOneNumber = numberOne.split(",");

        // then
        Assertions.assertThat(splitOneAndTwoNumber).contains("1");
        Assertions.assertThat(splitOneNumber).containsExactly("1");
    }

    @DisplayName("괄호를 제거하고 콤마를 기준으로 숫자를 분리한다.")
    @Test
    void splitNumberAfterDeleteParenthesis() {
        // given
        String number = "(1,2)";

        // when
        String result = number.substring(1, number.length()-1);

        // then
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("문자열에서 특정 위치의 문자를 가져온다.")
    @Test
    void extractChar() {
        // given
        String testData = "abc";

        // when
        char extractData = testData.charAt(0);

        // then
        Assertions.assertThat(extractData).isEqualTo('a');
    }
}