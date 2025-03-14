import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    StringAddCalculator cal = new StringAddCalculator();

    @Test
    @DisplayName(value="4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    void 콤마_콜론_구분자_합계(){
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    @DisplayName(value="3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)")
    void 콤마_합계(){
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    @DisplayName(value="2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)")
    void 문자열_단건(){
        assertEquals(1, cal.add("1"));
    }
}