package camp.nextstep.edu.rebellion.calc.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilTest {
    @DisplayName("입력한 문자열이 숫자인지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1:true",
            "2:true",
            "A:false",
            "B:false",
            "null:false"
    }, delimiter = ':')
    public void isNumericTest(String input, boolean expected) {
        // when
        boolean result = NumberUtil.isNumeric(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
