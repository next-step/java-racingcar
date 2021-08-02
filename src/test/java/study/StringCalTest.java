package study;

import Calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalTest {
    private Plus plus;
    private Subtract substract;
    private Multiply multiply;
    private Division division;
    private StringCalculationExecutor stringCalculationExecutor;


    @BeforeEach
    void setUp() {
        plus = new Plus();
        substract = new Subtract();
        multiply = new Multiply();
        division = new Division();
        stringCalculationExecutor = new StringCalculationExecutor();
    }

    @Test
    @DisplayName("빈 칸의 따라 문자나눈후 잘나뉘어져있는지 요소 찾기.")
    void emptySplit() {

        String[] numberAndOperator = "2 + 3 * 4 / 2".split(" ");
        assertThat(numberAndOperator).contains("2");
        assertThat(numberAndOperator).contains("+");
        assertThat(numberAndOperator).contains("3");

    }

    @Test
    @DisplayName("더하기 테스트")
    void plusCalculate() {
        assertThat(plus.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("마이너스 테스트")
    void subtarctCalculate() {
        assertThat(substract.calculate(3, 2)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multyplyCalculate() {
        assertThat(multiply.calculate(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divisionCalculate() {
        assertThat(division.calculate(10, 5)).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열 최종계산")
    void repeatStringCalculate() {
        String[] numberAndOperator = "2 + 3 * 4 / 2".split(" ");
        int result = stringCalculationExecutor.stringCalculator(numberAndOperator);
        assertThat(result).isEqualTo(10);
    }

}
