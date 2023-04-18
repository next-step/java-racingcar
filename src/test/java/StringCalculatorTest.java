import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void 구분자를_기준으로_분리한_숫자의_합을_반환() {
        String input = "1;2;3";

        final StringCalculator calculator = new StringCalculator();
        final int actual = calculator.sum(input);

        Assertions.assertEquals(6, actual);
    }

    @Test
    void 콜론을_기준으로_숫자_분리() {
        String input = "1;2;3";

        final StringCalculator calculator = new StringCalculator();
        final String[] components = calculator.split(input);

        Assertions.assertEquals("1", components[0]);
        Assertions.assertEquals("2", components[1]);
        Assertions.assertEquals("3", components[2]);
    }

    @Test
    void 쉼표를_기준으로_숫자_분리() {
        String input = "1,2,3";

        final StringCalculator calculator = new StringCalculator();
        final String[] components = calculator.split(input);

        Assertions.assertEquals("1", components[0]);
        Assertions.assertEquals("2", components[1]);
        Assertions.assertEquals("3", components[2]);
    }

    @Test
    void null을_입력하면_0_반환() {
        String input = null;

        final StringCalculator calculator = new StringCalculator();
        int actual = calculator.sum(input);

        Assertions.assertEquals(0, actual);
    }

    @Test
    void 빈문자열을_입력하면_0_반환() {
        String input = "";

        final StringCalculator calculator = new StringCalculator();
        int actual = calculator.sum(input);

        Assertions.assertEquals(0, actual);
    }
}
