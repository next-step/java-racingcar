import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void test() {
        Calculator calculator = new Calculator();
        String a = "1 + 3";

        assertThat(calculator.makeResult(a)).isEqualTo(4);
    }
}
