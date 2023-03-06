package calculator;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class calculate_test {

    @Test
    public void addtest() {
        System.out.println("add");
        int result = calculate.add(1, 2);
        assertThat(result).isEqualTo(3);
    }


    @Test
    public void subtracttest() {
        System.out.println("subtract");
        int result = calculate.subtract(5, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void multiplytest() {
        System.out.println("multifly");
        int result = calculate.multiply(1, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void dividetest() {
        System.out.println("divide");
        int result = calculate.divide(4, 2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void stringcalculate() {
        assertThat(10).isEqualTo(calculate.StringCalculator("2 + 3 * 4 / 2"));
    }

}
