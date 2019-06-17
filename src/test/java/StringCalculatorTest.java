import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    /*
    덧셈 함수 기능 및 단위 테스트 구현
    */
    @ParameterizedTest
    @ValueSource(strings = {"1+2", "2+3", "0+6"})
    void add(String input) {
        int signIndex = input.indexOf("+");
        int num1 = Character.getNumericValue(input.charAt(signIndex - 1));
        int num2 = Character.getNumericValue(input.charAt(signIndex + 1));
        assertThat(num1 + num2).isEqualTo(6);
    }

    /*
    뺄셈 함수 기능 및 단위 테스트 구현
    */
    @ParameterizedTest
    @ValueSource(strings = {"2-1", "5-2", "6-4"})
    void subtract(String input) {
        int signIndex = input.indexOf("-");
        int num1 = Character.getNumericValue(input.charAt(signIndex - 1));
        int num2 = Character.getNumericValue(input.charAt(signIndex + 1));
        assertThat(num1 - num2).isEqualTo(3);
    }

    /*
    곱셈 함수 기능 및 단위 테스트 구현
    */
    @ParameterizedTest
    @ValueSource(strings = {"2*8", "5*2", "6*4"})
    void multiply(String input) {
        int signIndex = input.indexOf("*");
        int num1 = Character.getNumericValue(input.charAt(signIndex - 1));
        int num2 = Character.getNumericValue(input.charAt(signIndex + 1));
        assertThat(num1 * num2).isEqualTo(10);
    }

    /*
    나눗셈 함수 기능 및 단위 테스트 구현
    */
    @ParameterizedTest
    @ValueSource(strings = {"8/2", "6/3", "5/5"})
    void divide(String input) {
        int signIndex = input.indexOf("/");
        int num1 = Character.getNumericValue(input.charAt(signIndex - 1));
        int num2 = Character.getNumericValue(input.charAt(signIndex + 1));
        assertThat(num1 / num2).isEqualTo(4);
    }
    /*
    공백 문자 or null 체크 기능 및 단위 테스트 구현
     */
    @Test
    void checkNullorBlankString() {
        String input = " ";
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    if (StringUtils.isBlank(input))
                        throw new IllegalArgumentException("입력값이 잘못되었습니다. 입력하신 문자열이 null 이거나 빈 공백 문자입니다.");
                }
        );
    }
    /*
    사칙연수 부호 체크 기능 및 단위 테스트 구현
     */
    @Test
    void checkOperationSign() {
        String input = "1 + 3 # 2";
        String[] array_input;

        array_input = input.split(" ");
        assertThatIllegalArgumentException().isThrownBy(() -> {

            for (int i = 0; i < array_input.length; ++i) {

                if (i % 2 == 1) {
                    switch (array_input[i]) {
                        case "+":
                            System.out.println("뎃셈 실행");
                            break;

                        case "-":
                            System.out.println("뺄셈 실행");
                            break;

                        case "*":
                            System.out.println("곱셈 실행");
                            break;

                        case "/":
                            System.out.println("나눗셈 실행");
                            break;

                        default:
                            throw new IllegalArgumentException("입력값이 잘못되었습니다. 사칙연산이 아닌 기호가 입력되었습니다.");

                    }
                }

            }
        });

    }


}
