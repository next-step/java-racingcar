package test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.Calculator;
import step1.InputEmptyDataException;
import step1.InputWrongSignDataException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    String expression = "";
    Calculator calculator = null;
    @BeforeEach
    void setUp() {
        a = 10;
        b = 15;
        c = 20;
        d = 40;
        expression = "1 - 3 + 4 * 10 / 7";
        calculator = new Calculator();
    }


    @Test
    @DisplayName("더하기 Test")
    public void sum() {
        assertThat(calculator.sum(a,b)).isEqualTo(25);
    }

    @Test
    @DisplayName("뺄셈 Test")
    void minus() {
        assertThat(calculator.minus(a,b)).isEqualTo(-5);
    }

    @Test
    @DisplayName("곱셈 Test")
    void multiply() {
        assertThat(calculator.multiply(a,b)).isEqualTo(150);
    }

    @Test
    @DisplayName("나눗셈 Test")
    void divide() {
        assertThat(calculator.divide(a,b)).isEqualTo(0);
    }

    @Test
    @DisplayName("빈칸있을때까지 숫자 변환 Test")
    void changeNum() {
        String str = "123 ";
        String testStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (' ' == (str.charAt(i))) {
                break;
            }
            testStr += str.charAt(i);
        }
        assertThat(Integer.parseInt(testStr)).isEqualTo(123);
    }


    @Test
    @DisplayName("계산 Test")
    void executeTest() throws InputWrongSignDataException, InputEmptyDataException {
        int result = new Calculator().execute(expression);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("빈 문자열이 입력되었는지 확인")
    void checkEmptyDataTest(){
        String str = "    ";
        String[] strArr = str.split(" ");
        for(String str2 : strArr){
            System.out.println(str2);
        }
        assertThat(new Calculator().checkInputEmptyData(strArr)).isTrue();
    }

    @Test
    @DisplayName("다른 기호가 들어있을 경우 확인")
    void checkWrongSignDataTest(){
        String str = "1 & 8 $ 52";
        String[] strArr = str.split(" ");

        assertThatThrownBy(() -> {
            assertThat(new Calculator().checkInputSignWrongData(strArr)).isTrue();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 문자열이 아닙니다.");

    }


}
