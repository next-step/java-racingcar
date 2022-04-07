package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCalculatorTest {

    @Test
    public void 쉼표또는콜론_구분자_덧셈_계산기테스트() {
        assertEquals(AddCalculator.execute("1:2:3"), 6);
        assertEquals(AddCalculator.execute("1,2,3"), 6);
        assertEquals(AddCalculator.execute("1:2,3"), 6);
    }

    @Test
    public void 널또는_빈문자열_덧셈_계산기테스트() {
        assertEquals(AddCalculator.execute(null), 0);
        assertEquals(AddCalculator.execute(""), 0);
    }

    @Test
    public void 커스텀_구분자_덧셈_계산기테스트() {
        assertEquals(AddCalculator.execute("//;\n1;2;3"), 6);
    }

    @Test
    public void 숫자이외의_값은_에러처리() {
        assertThatThrownBy(() -> AddCalculator.execute("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 숫자만_있는경우_테스트() {
        assertEquals(AddCalculator.execute("123"),123);
    }
}
