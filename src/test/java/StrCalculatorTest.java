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
    void divByZeroTest() {
        assertThatThrownBy(() -> {
            StrCalculator cal = new StrCalculator();
            String a = "6", b = "0";
            String result = cal.div(a, b);

            assertThat(result).isEqualTo("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("divided by 0");
    }

    @Test
    void emptyOperationTest() {
        assertThatThrownBy(() -> {
            StrCalculator cal = new StrCalculator();
            String oper = "";
            cal.checkOperation(oper);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Operation is empty");
    }

    @Test
    void splitOperTest() {
        String test = "1 + 2 + 3 + 4";
        StrCalculator cal = new StrCalculator();

        String[] testList = cal.splitOper(test);
        assertThat(testList).containsExactly("1", "+", "2", "+", "3", "+", "4");
    }

    @Test
    void separationTest() {
        String[] test = {"1", "+", "2", "+", "3"};
        StrCalculator cal = new StrCalculator();

        String[] subList = cal.separation(test);

        assertThat(subList).containsExactly("1", "+", "2");
    }

    @Test
    void calOneByOneAddTest() {
        String[] addTest = {"1", "+", "2"};
        StrCalculator cal = new StrCalculator();

        String result = cal.calOneByOne(addTest);
        assertThat(result).isEqualTo("3");
    }

    @Test
    void calOneByOneSubTest() {
        String[] subTest = {"3", "-", "1"};
        StrCalculator cal = new StrCalculator();

        String result = cal.calOneByOne(subTest);
        assertThat(result).isEqualTo("2");
    }

    @Test
    void calOneByOneMultiTest() {
        String[] multiTest = {"2", "*", "3"};
        StrCalculator cal = new StrCalculator();

        String result = cal.calOneByOne(multiTest);
        assertThat(result).isEqualTo("6");
    }

    @Test
    void calOneByOneDivTest() {
        String[] divTest = {"6", "/", "2"};
        StrCalculator cal = new StrCalculator();

        String result = cal.calOneByOne(divTest);
        assertThat(result).isEqualTo("3");
    }

    @Test
    void calOneByOneDivByZeroTest() {
        assertThatThrownBy(() -> {
            String[] divTest = {"6", "/", "0"};
            StrCalculator cal = new StrCalculator();

            String result = cal.calOneByOne(divTest);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Divided by 0.");
    }
}
