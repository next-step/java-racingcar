package stringcalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @Test
    void 생성() {
        Calculator calculator = new Calculator("1 + 2");
        assertThat(calculator).isEqualTo(new Calculator("1 + 2"));
    }

    @Test
    void NULL_입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator(null));
    }

    @Test
    void 빈공백_입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator(" "));
    }

    @Test
    void 잘못된입력_부족한_연산자() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator("1 1 + 2 + 3"));
    }

    @Test
    void 잘못된입력_부족한_피연산자() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator("1 + + 2 + 3"));
    }

    @Test
    void 잘못된입력_유효하지않은_연산자() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator("1 # 2 + 3"));
    }

    @Test
    void 계산() {
        Calculator calculator = new Calculator("1 + 2 + 3 + 4 + 5");
        assertThat(calculator.calculate()).isEqualTo(15);
    }
}
