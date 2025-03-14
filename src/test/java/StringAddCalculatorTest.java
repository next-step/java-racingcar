import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    StringAddCalculator cal = new StringAddCalculator();

    @Test
    @DisplayName(value="숫자 형태의 문자를 숫자로 변형")
    void 문자열_단건(){
        assertEquals(1, cal.add("1"));
    }
}