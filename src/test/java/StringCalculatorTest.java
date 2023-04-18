import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void 커스텀_구분자가_포함된_문자열_합_반환() {
        String input = "//;\\n1;2;3";

        final StringCalculator calculator = new StringCalculator();
        final int actual = calculator.sum(input);

        assertEquals(6, actual);
    }

    @Test
    void 커스텀_구분자_분리() {
        String input = "//;\\n1;2;3";

        final StringCalculator calculator = new StringCalculator();
        final String[] components = calculator.split(input);

        assertEquals("1", components[0]);
        assertEquals("2", components[1]);
        assertEquals("3", components[2]);
    }

    @Test
    void 구분자를_기준으로_분리한_숫자의_합을_반환() {
        String input = "1;2;3";

        final StringCalculator calculator = new StringCalculator();
        final int actual = calculator.sum(input);

        assertEquals(6, actual);
    }

    @Test
    void 콜론을_기준으로_숫자_분리() {
        String input = "1;2;3";

        final StringCalculator calculator = new StringCalculator();
        final String[] components = calculator.split(input);

        assertEquals("1", components[0]);
        assertEquals("2", components[1]);
        assertEquals("3", components[2]);
    }

    @Test
    void 쉼표를_기준으로_숫자_분리() {
        String input = "1,2,3";

        final StringCalculator calculator = new StringCalculator();
        final String[] components = calculator.split(input);

        assertEquals("1", components[0]);
        assertEquals("2", components[1]);
        assertEquals("3", components[2]);
    }

    @Test
    void null을_입력하면_0_반환() {
        String input = null;

        final StringCalculator calculator = new StringCalculator();
        int actual = calculator.sum(input);

        assertEquals(0, actual);
    }

    @Test
    void 빈문자열을_입력하면_0_반환() {
        String input = "";

        final StringCalculator calculator = new StringCalculator();
        int actual = calculator.sum(input);

        assertEquals(0, actual);
    }
}
