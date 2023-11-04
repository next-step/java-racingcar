package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CTest {

    @Test
    void null_값() {
        int result = Calculator.cal(null);
        assertThat(result).isEqualTo(0);


    }


    @Test
    void 숫자_하나() {
        assertThat()
    }
}
