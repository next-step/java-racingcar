import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StrCalculatorTest {

    @Test
    void sumTest() {
        StrCalculator cal = new StrCalculator();
        String a = "1", b = "2";
        String result = cal.sum(a, b);

        assertThat(result).isEqualTo("3");
    }
    @Test
    void subTest() {
        StrCalculator cal = new StrCalculator();
        String a = "1", b = "2";
        String result = cal.sub(a, b);

        assertThat(result).isEqualTo("-1");
    }
    @Test
    void multiTest() {
        StrCalculator cal = new StrCalculator();
        String a = "2", b = "3";
        String result = cal.multi(a, b);

        assertThat(result).isEqualTo("6");
    }
    @Test
    void divTest() {
        StrCalculator cal = new StrCalculator();
        String a = "12", b = "2";
        String result = cal.div(a, b);

        assertThat(result).isEqualTo("6");
    }

    @Test
    void emptyExpressionTest() {
        assertThatThrownBy(() -> {
            StrCalculator cal = new StrCalculator();
            String expr = "";
            cal.checkExpression(expr);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("expression is empty");
    }

    @Test
    void separationTest() {
        String[] test = {"1", "+", "2", "+", "3"};
        StrCalculator cal = new StrCalculator();

        String [] subList = cal.separation(test);

        assertThat(subList).containsExactly("1","+","2");
    }
}
