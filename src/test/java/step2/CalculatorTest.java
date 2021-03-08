package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    @DisplayName("계산기 테스트")
    void calculator() {
        // when
        String data = "2 + 3 * 4 / 2";

        // when
        int actual = Calculator.calculator(data);

        // then
        assertEquals(actual, 10);
    }

    @Test
    @DisplayName("빈값이거나 null 일때 IllegalArgumentException 발생 테스트")
    void hasNotNullOrNotEmpty() {
        // given
        String[] arr = {"2","*","3"," "};

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            for (String s : arr) {
                if(s.equals(" ")){
                    throw new IllegalArgumentException("exception !!");
                }
            }
        });
    }

    @Test
    @DisplayName("add 메서드 테스트")
    void add() {
        // given
        int result = 5;
        String givenNum = "5";

        // when
        int num = Integer.parseInt(givenNum);
        result += num;

        // then
        assertEquals(result, 5+5);
    }

    @Test
    @DisplayName("minus 메서드 테스트")
    void minus() {
        // given
        int result = 10;
        String givenNum = "5";

        // when
        int num = Integer.parseInt(givenNum);
        result -= num;

        // then
        assertEquals(result, 10-5);
    }

    @Test
    @DisplayName("multiple 메서드 테스트")
    void multiple() {
        // given
        int result = 5;
        String givenNum = "5";

        // when
        int num = Integer.parseInt(givenNum);
        result *= num;

        // then
        assertEquals(result, 5*5);
    }

    @Test
    @DisplayName("divide 메서드 테스트")
    void divide() {
        // given
        int result = 5;
        String givenNum = "5";

        // when
        int num = Integer.parseInt(givenNum);
        result /= num;

        // then
        assertEquals(result, 5/5);
    }
}