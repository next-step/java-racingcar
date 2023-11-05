import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringCalculatorTest {

// 요구 사항 정의



    @Test
    @DisplayName("설명 입력하기")
    void writingMethodName(String target) throws Exception {
        // 구분자 구하기
        int result = StringCalculator.cal(null);
        Assertions.assertThat(result).isEqualTo(0);
    }
}
