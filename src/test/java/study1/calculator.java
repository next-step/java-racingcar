package study1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class calculator {
    private String[] inputList;

    public int calculate(String input){
        if(inputNullCheck(input)){
            throw new IllegalArgumentException();
        }
        // 숫자인지 기호인지 체크
        // 기호일 땐 + - * / 인지 체크
        inputList = input.split(" ");
        int result = Integer.parseInt(inputList[0]);
        for(int i = 1; i <inputList.length; i++){
            result = calculate_func(result, i);
        }
        return result;
    }

    private int calculate_func(int result, int index){
        // null과 연산자에 대해서만 예외처리를 하도록 하였기에 inputList 짝수 element 기호라고 가정함
        if(index%2 == 1){
            int inputParam = Integer.parseInt(inputList[index+1]);
            switch (inputList[index]){
                case "+":
                    return sum(result, inputParam);
                case "-":
                    return subtraction(result, inputParam);
                case "*":
                    return multiplication(result, inputParam);
                case "/":
                    return division(result, inputParam);
                default:
                    throw new IllegalArgumentException();
            }
        }
        return result;
    }

    private int sum(int result, int param){
        return result+param;
    }

    private int subtraction(int result, int param){
        return result-param;
    }

    private int multiplication(int result, int param){
        return result*param;
    }

    private int division(int result, int param){
        return result/param;
    }

    private boolean inputNullCheck(String input) { return "".equals(input.trim()); }

    @ParameterizedTest
    @DisplayName("입력값 검증 테스트")
    @ValueSource(strings = {"    ", ""})
    void isNullCheckTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculate(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ~ 1", "1 ! 2"})
    void calculateSymbolCheckTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculate(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "12 * 3 + 4 / 2:20", "1 + 1 + 1 + 1:4", "4 * 4:16"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, int result) {
        assertThat(calculate(input)).isEqualTo(result);
    }
}
