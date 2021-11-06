package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void plus() {
        int acc = Calculator.calculate("1 + 2");
        assertThat(acc).isEqualTo(3);
    }

    @Test
    public void minus() {
        int acc = Calculator.calculate("3 - 2");
        assertThat(acc).isEqualTo(1);
    }

    @Test
    public void times() {

        int acc = Calculator.calculate("3 * 2");
        assertThat(acc).isEqualTo(6);
    }

    @Test
    public void dividedBy() {
        int acc = Calculator.calculate("4 / 2");
        assertThat(acc).isEqualTo(2);
    }

    @Test
    void dividedByZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            int acc = Calculator.calculate("4 / 0");
        }).withMessageMatching("분모는 0이 될 수 없습니다.");

    }

    @Test
    public void plus2() {
        int acc = Calculator.calculate2("1 + 2");
        assertThat(acc).isEqualTo(3);
    }

    @Test
    public void minus2() {
        int acc = Calculator.calculate2("3 - 2");
        assertThat(acc).isEqualTo(1);
    }

    @Test
    public void times2() {

        int acc = Calculator.calculate2("3 * 2");
        assertThat(acc).isEqualTo(6);
    }

    @Test
    public void dividedBy2() {
        int acc = Calculator.calculate2("4 / 2");
        assertThat(acc).isEqualTo(2);
    }

    @Test
    void dividedByZero2() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            int acc = Calculator.calculate2("4 / 0");
        }).withMessageMatching("분모는 0이 될 수 없습니다.");

    }

}
