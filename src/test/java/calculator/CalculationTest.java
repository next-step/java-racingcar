package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationTest {

    @BeforeEach
    void setUp() {
        Calculation cal = new Calculation();
        cal.test();
    }

    @Test
    void valueConfirm() {
        Calculation cal = new Calculation();
        cal.test();

        assertThatThrownBy(() -> {
            System.out.println(cal.numbers[cal.numbers.length - 1]);
            assertThat(cal.numbers[cal.numbers.length - 1]).isEqualTo("10");
        }).isInstanceOf(IllegalArgumentException.class);
    }
//     Test Case 구현
//    @ParameterizedTest
//    @ValueSource(strings = {"+","-","*","/"}) // six numbers
//    void contains(int operator) {
//        Calculation cal = new Calculation();
//        cal.test();
//    }
}
