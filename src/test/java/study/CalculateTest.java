package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculateTest {
    private String formula = "";
    private int result = 0;

    @AfterEach
    void afterAll() {
        System.out.println("결과 : " + result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("테스트 데이터 전달 시연")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThat(formula).isEqualTo(input);
    }

    @Test
    @DisplayName("계산기 실행 - 성공")
    void calculator_success() {
        formula = "2 + 3 * 4 / 2";
        System.out.println("계산식 : " + formula);
        calculator();
    }

    @Test
    @DisplayName("계산기 실행 - 실패(공식 미입력)")
    void calculator_empty_formula_fail() {
        formula = "";
        System.out.println("계산식 : " + formula);
        calculator();
    }

    @Test
    @DisplayName("계산기 실행 - 실패(연속된 사칙연산)")
    void calculator_wrong_formula_fail() {
        formula = "2 + 3 * 4 / / 2";
        System.out.println("계산식 : " + formula);
        calculator();
    }

    @Test
    @DisplayName("계산기 실행 - 실패(첫번째 값이 문자)")
    void calculator_first_value_wrong_fail() {
        formula = "+ + 3 * 4 / 2";
        System.out.println("계산식 : " + formula);
        calculator();
    }

    /**
     * 계산기 실행
     *
     */
    void calculator() {
        // 공식 유효성 검사 후 성공 시 배열 발행
        String[] values = checkFormulaIsValid();
        for (int i = 0; i < values.length; i++) {
            // 첫번째 배열 값을 디폴트로 입력
            if (i == 0) {
                result = Integer.parseInt(values[i]);
                continue;
            }
            // 첫번째 이후 값들을 계산 실행
            calculation(values[i], values[i+1]);
            i++;
        }
    }

    /**
     * 공식 유효성 검사
     *
     * @return String[]
     */
    private String[] checkFormulaIsValid() {
        // 공식 미입력 여부 체크
        assertThat(formula.isEmpty()).isFalse();
        // 배열 발행
        String[] values = formula.split(" ");
        // 첫번째 또는 마지막 문자 형태가 계산식인지 체크
        checkFirstAndLastFormulaValueIsNumeric(values[0], values[values.length -1]);
        for (int i = 0; i < values.length; i++) {
            // 마지막 배열 값일 경우 검증 종료
            if(i == values.length -1) {
                break;
            }
            // 같은 문자 형태가 동시에 발생하는지 체크 ex) 3 3, + +
            checkSameCharacterContinuous(values[i], values[i+1]);
        }

        return values;
    }

    /**
     * 더하기
     *
     * @param value
     */
    private void plus(int value) {
         result += value;
    }

    /**
     * 빼기
     *
     * @param value
     */
    private void minus(int value) {
        result -= value;
    }

    /**
     * 곱하기
     *
     * @param value
     */
    private void multiple(int value) {
        result *= value;
    }

    /**
     * 나누기
     *
     * @param value
     */
    private void divide(int value) {
        result /= value;
    }

    /**
     * 문자인지 숫자인지 확인
     *
     * @param value
     * @return boolean
     */
    boolean isNumeric(String value) {
        try{
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * 같은 문자 형태가 동시에 발생하는지 체크 ex) 3 3, + +
     *
     * @param before
     * @param next
     */
    void checkSameCharacterContinuous(String before, String next) {
        if(isNumeric(before) == isNumeric(next)) {
            throwIllegalArgumentException("같은 문자 형태가 이어지게 나올 수 없습니다.");
        }
    }

    /**
     * 첫번째 또는 마지막 문자 형태가 숫자인지 체크
     *
     * @param firstValue
     * @param lastValue
     */
    void checkFirstAndLastFormulaValueIsNumeric(String firstValue, String lastValue) {
        if(!isNumeric(firstValue) || !isNumeric(lastValue)) {
            throwIllegalArgumentException("공식의 첫번째 또는 마지막엔 문자가 올 수 없습니다.");
        }
    }

    /**
     * 계산 실행
     *
     * @param operation
     * @param value
     */
    void calculation(String operation, String value) {
        if(!isNumeric(operation)) {
            switch (operation) {
                case "+" :
                    plus(Integer.parseInt(value));
                    break;
                case "-" :
                    minus(Integer.parseInt(value));
                    break;
                case "*" :
                    multiple(Integer.parseInt(value));
                    break;
                case "/" :
                    divide(Integer.parseInt(value));
                    break;
                default:
                    throwIllegalArgumentException("잘못된 사칙연산");
            }
        }
    }

    /**
     * 잘못된 값을 입력 시 에러 메시지 출력
     *
     * @param message
     */
    void throwIllegalArgumentException(String message) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            throw new Exception(message);
        });
    }
}
