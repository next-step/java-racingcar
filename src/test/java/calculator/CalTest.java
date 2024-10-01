package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalTest {

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 시 해당 숫자를 반환하는지 확인")
    void oneStringNumTest() {
        int result = Cal.cal("1");
        assertThat(result).isEqualTo(1);
    }


}
