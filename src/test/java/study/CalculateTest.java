package study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculateTest {
    Calculate calc = new Calculate();

    @Test
    @DisplayName("빈 문자열인 경우 0으로 반환한다.")
    void empty_returnsZero() {
        assertEquals(0, calc.calculate(""));
    }

    @ParameterizedTest(name = "단일 숫자 \"{0}\"을(를) 전달하면 그대로 반환한다 → {1}")
    @CsvSource({
        "0, 0",
        "7, 7",
        "42, 42"
    })
    void singleNumber(String input, int expected) {
        assertEquals(expected, calc.calculate(input));
    }

    @ParameterizedTest(name = "쉼표/콜론으로 구분한 \"{0}\"의 합은 {1}이다")
    @CsvSource({
        "'1,2', 3",
        "'1,2,3', 6",
        "'1:2:3', 6",
        "'1,2:3', 6",
        "'10,20:30', 60"
    })
    void baseDelimiters(String input, int expected) {
        assertEquals(expected, calc.calculate(input));
    }



    @Test
    @DisplayName("커스텀 헤더만 있고 본문이 비면 parse error를 던진다")
    void customHeaderButNoNumbers() {
        RuntimeException ex = assertThrows(RuntimeException.class,
            () -> calc.calculate("//;\\n"));
        assertEquals("parse error", ex.getMessage());
    }

    @Test
    @DisplayName("음수가 포함되면 minus number error를 던진다")
    void negativeNumber() {
        RuntimeException ex = assertThrows(RuntimeException.class,
            () -> calc.calculate("1,-2,3"));
        assertEquals("minus number error", ex.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 토큰이 있으면 parse error를 던진다")
    void nonNumericToken() {
        RuntimeException ex = assertThrows(RuntimeException.class,
            () -> calc.calculate("1,a:3"));
        assertEquals("parse error", ex.getMessage());
    }

    @Test
    @DisplayName("커스텀 헤더 형식이 잘못되면 예외를 던진다(개행 누락 등)")
    void malformedCustomHeader() {
        RuntimeException ex = assertThrows(RuntimeException.class,
            () -> calc.calculate("//;1;2;3")); // 개행 누락
        assertTrue(
            ex.getMessage().equals("custom header mismatch") ||
                ex.getMessage().equals("parse error")
        );
    }

    @Test
    @DisplayName("커스텀/기본 구분자를 혼용해도 합산된다 → //;\n1;2,3:4 = 10")
    void customAndBaseMixed() {
        assertEquals(10, calc.calculate("//;\n1;2,3:4"));
    }
}
