import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Set 자료형 관련 테스트")
public class SetTest {

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

    @DisplayName("존재하지 않는 문자열의 인덱스에 접근하면 예외가 발생한다.")
    @Test
    void indexBoundException() {
        // given
        String testData = "abc";

        // when & then
        Assertions.assertThatThrownBy(() -> {
            testData.charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}