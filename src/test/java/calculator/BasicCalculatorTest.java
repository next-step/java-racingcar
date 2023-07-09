package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicCalculatorTest {

    @Test
    @DisplayName("쉼표 구분자를 기준으로 숫자의 합을 반환")
    void commaSum() {
        assertEquals(3, Calculator.sum("1,2"));
        assertEquals(6, Calculator.sum("1,2,3"));
        assertEquals(0, Calculator.sum(""));
    }

    @Test
    @DisplayName("클론 구분자를 기준으로 숫자의 합을 반환")
    void colonSum() {
        assertEquals(3, Calculator.sum("1:2"));
    }

    @Test
    @DisplayName("기본 구분자 전체 테스트")
    void basicSeperatorTest() {
        assertEquals(6, Calculator.sum("1,2:3"));

    }
}
