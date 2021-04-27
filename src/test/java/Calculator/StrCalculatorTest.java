package Calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<String> testList = cal.splitOper(test);
        assertThat(testList).containsExactly("1", "+", "2", "+", "3", "+", "4");
    }

    @Test
    void separationTest() {
        String[] test = {"1", "+", "2", "+", "3"};
        StrCalculator cal = new StrCalculator();

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(test));
        ArrayList<String> subList = cal.separation(list);

        assertThat(subList).containsExactly("1", "+", "2");
        assertThat(list).containsExactly("+", "3");
    }

    @Test
    void calOneByOneAddTest() {
        ArrayList<String> addTest = new ArrayList<String>(Arrays.asList("1", "+", "2"));
        StrCalculator cal = new StrCalculator();

        String result = cal.calOneByOne(addTest);
        assertThat(result).isEqualTo("3");
    }

    @Test
    void calOneByOneSubTest() {
        ArrayList<String> subTest = new ArrayList<String>(Arrays.asList("3", "-", "1"));
        StrCalculator cal = new StrCalculator();

        String result = cal.calOneByOne(subTest);
        assertThat(result).isEqualTo("2");
    }

    @Test
    void calOneByOneMultiTest() {
        ArrayList<String> multiTest = new ArrayList<String>(Arrays.asList("2", "*", "3"));
        StrCalculator cal = new StrCalculator();

        String result = cal.calOneByOne(multiTest);
        assertThat(result).isEqualTo("6");
    }

    @Test
    void calOneByOneDivTest() {
        ArrayList<String> divTest = new ArrayList<String>(Arrays.asList("6", "/", "2"));
        StrCalculator cal = new StrCalculator();

        String result = cal.calOneByOne(divTest);
        assertThat(result).isEqualTo("3");
    }

    @Test
    void calOneByOneDivByZeroTest() {
        assertThatThrownBy(() -> {
            ArrayList<String> divTest = new ArrayList<String>(Arrays.asList("6", "/", "0"));
            StrCalculator cal = new StrCalculator();

            String result = cal.calOneByOne(divTest);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Divided by 0.");
    }

    @Test
    void combineListTest() {
        ArrayList<String> test = new ArrayList<String>(Arrays.asList("+", "2", "+", "3"));
        String first = "1";
        StrCalculator cal = new StrCalculator();

        cal.combineList(test, first);
        assertThat(test).containsExactly("1", "+", "2", "+", "3");
    }

    @Test
    void calculateTest() {
        String problem = "1 + 2 + 3 + 4";
        StrCalculator cal = new StrCalculator();

        String result = cal.calculate(problem);

        assertThat(result).isEqualTo("10");
    }

    @Test
    void calculateTest2() {
        String problem =  "2 + 3 * 4 / 2";
        StrCalculator cal = new StrCalculator();

        String result = cal.calculate(problem);

        assertThat(result).isEqualTo("10");
    }
}
