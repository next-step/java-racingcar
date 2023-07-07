package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomSeparatorSumTest {

    @Test
    @DisplayName("커스텀 구분자를 기준으로 숫자의 합을 반환 ('//' '\n')")
    void customSum() {
        assertEquals(3, Calculator.sum("//;\n1;2"));
        assertEquals(6, Calculator.sum("//!\n1!2!3"));
    }
}
