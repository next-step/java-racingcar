package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    @DisplayName("구분자 문자열 분리 후 숫자 합 반환 테스트")
    void stringSplitAndSumTest() {
        String input = "1,2,3";
        String spliter = ",|:";
        String[] list = input.split(spliter);
    }
}
