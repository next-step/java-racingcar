package calculator2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicTest {

    @Test
    @DisplayName("쉼표 구분자를 기준으로 숫자의 합을 반환")
    void 쉼표_구분자_숫자_합_반환() {
        assertEquals(3, Calculator.sum("1,2"));
        assertEquals(6, Calculator.sum("1,2,3"));
        assertEquals(0, Calculator.sum(""));
    }

    @Test
    @DisplayName("클론 구분자를 기준으로 숫자의 합을 반환")
    void colonSum() {
        assertEquals(3, Calculator.sum("1:2"));
        assertEquals(6, Calculator.sum("1:2:3"));
        assertEquals(0, Calculator.sum(""));
    }
}
