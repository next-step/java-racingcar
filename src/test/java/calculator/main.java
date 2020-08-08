package calculator;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.Strings;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertTrue;

public class main {

    @Test
    public void calculation() {
        String[] values = "1 + 2 * 3 + 5 - 2".split(" ");
        int result = Integer.parseInt(values[0]);
        /*
        for (int i=1; i<values.length; i+=2) {
            isBlank_ShouldReturnTrueForNullOrBlankStrings(values[i-1]);   //빈값확인
            isBlank_ShouldReturnTrueForNullOrBlankStrings(values[i]);   //빈값확인
            isBlank_ShouldReturnTrueForNullOrBlankStrings(values[i+1]);   //빈값확인
            isNumber(values[i-1]);
            isNumber(values[i+1]);
            isCalculate(values[i]);

            if(values[i].equals("+")) {
                result = add(result,Double.parseDouble(values[i+1]));
            }
            if(values[i].equals("-")) {
                result = subtract(result,Double.parseDouble(values[i+1]));
            }
            if(values[i].equals("*")) {
                result = multiply(result,Double.parseDouble(values[i+1]));
            }
            if(values[i].equals("/")) {
                divisorCheck(values[i]);  //분모확인
                result = divide(Double.parseDouble(values[i-1]),Double.parseDouble(values[i+1]));
            }
        }
         */
        for (int i=0; i<values.length; i++) {
            isBlank_ShouldReturnTrueForNullOrBlankStrings(values[i]);   //빈값확인

            if(i % 2 == 1){
                isCalculate(values[i]);
                if(values[i].equals("+")) {
                    result = add(result,Integer.parseInt(values[i+1]));
                }
                if(values[i].equals("-")) {
                    result = subtract(result,Integer.parseInt(values[i+1]));
                }
                if(values[i].equals("*")) {
                    result = multiply(result,Integer.parseInt(values[i+1]));
                }
                if(values[i].equals("/")) {
                    divisorCheck(values[i]);  //분모확인
                    result = divide(result,Integer.parseInt(values[i+1]));
                }
            } else {
                isNumber(values[i]);
            }
        }
        System.out.println(result);
    }
    private int add(int a, int b) {
        return a+b;
    }
    private int subtract(int a, int b) {
        return a-b;
    }
    private int multiply(int a, int b) {
        return a*b;
    }
    private int divide(int a, int b) {
        return a/b;
    }

    @ParameterizedTest
    private void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            if(!Strings.isBlank(input)){
                throw new IllegalArgumentException("숫자또는 사칙연산을 입력해주세요.");
            };
        }).withMessage("숫자또는 사칙연산을 입력해주세요.");
    }

    @ParameterizedTest
    private void isNumber(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            if(!Strings.isNumber(input)){
                throw new IllegalArgumentException("숫자또는 사칙연산을 입력해주세요.");
            };
        }).withMessage("숫자또는 사칙연산을 입력해주세요.");
    }

    @ParameterizedTest
    private void isCalculate(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            if(!Strings.isCalculate(input)){
                throw new IllegalArgumentException("사칙연산을 입력해주세요.");
            }
        }).withMessage("사칙연산을 입력해주세요.");
    }

    @ParameterizedTest
    private void divisorCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            if(input.equals("0")) {
                throw new IllegalArgumentException("0으로 나눌수 없습니다.");
            }
        }).withMessage("0으로 나눌수 없습니다.");
    }
}
