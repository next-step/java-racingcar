package calculator2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomSeparatorSumTest {
    @Test
    @DisplayName("커스텀 구분자를 기준으로 숫자의 합을 반환 ('//' 'n')")
    void customSum() {
        assertEquals(3, Calculator.sum("//;\n1;2"));
    }
}
