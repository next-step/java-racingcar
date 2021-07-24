package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private String inputStr;
    String inputStrOnlyPlus;
    String inputStrOnlyMinus;
    String inputStrOnlyMultiplication;
    String inputStrOnlyDevide;

    @BeforeEach
    void setUp() {
        inputStr = "2 + 3 * 4 / 2";                     // result : 10
        inputStrOnlyPlus = "2 + 3 + 4 + 2";             // result : 11
        inputStrOnlyMinus = "12 - 3 - 4 - 2";           // result : 3
        inputStrOnlyMultiplication = "2 * 3 * 4 * 2";   // result : 48
        inputStrOnlyDevide = "1000 / 2 / 4 / 5";        // result : 25
    }

    @DisplayName("Test calculate plus")
    @Test
    void CalcPlusTest() {
        Calculator calculator = new Calculator();
        int reuslt = calculator.calc(inputStrOnlyPlus);
        System.out.println("result : " + reuslt);
        assertThat(reuslt).isEqualTo(11);
    }

    @DisplayName("Test calculate minus")
    @Test
    void CalcMinusTest() {
        Calculator calculator = new Calculator();
        int reuslt = calculator.calc(inputStrOnlyMinus);
        System.out.println("result : " + reuslt);
        assertThat(reuslt).isEqualTo(3);
    }

    @DisplayName("Test calculate Multiplication")
    @Test
    void CalcMultiplicationTest() {
        Calculator calculator = new Calculator();
        int reuslt = calculator.calc(inputStrOnlyMultiplication);
        System.out.println("result : " + reuslt);
        assertThat(reuslt).isEqualTo(48);
    }

    @DisplayName("Test calculate Divide")
    @Test
    void CalcDivideTest() {
        Calculator calculator = new Calculator();
        int reuslt = calculator.calc(inputStrOnlyDevide);
        System.out.println("result : " + reuslt);
        assertThat(reuslt).isEqualTo(25);
    }

    @DisplayName("Test calculate total")
    @Test
    void CalcTotalTest() {
        Calculator calculator = new Calculator();
        int reuslt = calculator.calc(inputStr);
        System.out.println("result : " + reuslt);
        assertThat(reuslt).isEqualTo(10);
    }
}
