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
}