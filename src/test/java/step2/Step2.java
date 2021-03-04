package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Step2 {


    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("더하기 테스트")
    @Test
    public void 더하기테스트(){
        assertThat(calculator.plus(1,2)).isEqualTo(3);
        assertThat(calculator.plus(2,5)).isEqualTo(7);
        assertThat(calculator.plus(-1,4)).isEqualTo(3);
    }

    @DisplayName("빼기 테스트")
    @Test
    public void 빼기테스트(){
        assertThat(calculator.minus(3,2)).isEqualTo(1);
        assertThat(calculator.minus(1,-2)).isEqualTo(3);
        assertThat(calculator.minus(1,2)).isEqualTo(-1);
    }

    @DisplayName("나누기 테스트")
    @Test
    public void 나누테스트(){
        assertThat(calculator.divide(2,2)).isEqualTo(1);
        assertThat(calculator.divide(25,5)).isEqualTo(5);
        assertThat(calculator.divide(30,5)).isEqualTo(6);
    }

    @DisplayName("곱하기 테스트")
    @Test
    public void 곱하기(){
        assertThat(calculator.multiply(10,10)).isEqualTo(100);
        assertThat(calculator.multiply(30,1)).isEqualTo(30);
        assertThat(calculator.multiply(40,4)).isEqualTo(160);
    }

    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 ")
    @Test
    public void 공백문자열널테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    calculator.isEmptyInput(null);
                });
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    calculator.isEmptyInput("");
                });
    }

    @DisplayName("잘 계산 되는지 테스트")
    @Test
    public void 계산테스트() {
        assertThat(calculator.operation("2 + 3 * 4 / 2")).isEqualTo(10);
    }

}
