package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class calcTest {

    @DisplayName("입력받은 문자열을 배열에 담은 후 사이즈 확인")
    @ParameterizedTest
    @MethodSource("initDataAndResult")
    void checkInputData(String inData, boolean result) {
        boolean actual = false;

        if (inData != null && !inData.equals("")) {
            actual = true;
        }

        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("입력받은 문자열을 배열에 담은 후 사이즈 확인")
    @ParameterizedTest
    @MethodSource("inDataAndResult")
    void splitInputData(String inData, boolean result){
        boolean actual = false;
        String[] arrInData = {};

        arrInData = inData.split(" ");

        if(arrInData.length > 0){
            actual = true;
        }

        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("입력받은 문자가 숫자인지 아닌지 확인하여 숫자만 true를 반환")
    @ParameterizedTest
    @MethodSource("arrayAndResult")
    void isNumber(char inData, boolean result){
        boolean actual = Character.isDigit(inData);
        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("입력받은 문자가 연산자인지 아닌지 확인하여 연산자만 true를 반환")
    @ParameterizedTest
    @MethodSource("testDataAndResult")
    void isOperator(String optData, boolean result){
        String[] operator = {"+","-","*","/"};
        boolean isOpt = false;
        for(String arrOpt : operator) {
            if(arrOpt.equals(optData)) {
                isOpt = true;
            }
        }
        assertThat(isOpt).isEqualTo(result);
    }

    @DisplayName("입력받은 2개 정수를 더한 후 결과값을 반환")
    @ParameterizedTest
    @MethodSource("addInputAndResult")
    void add(int operand1, int operand2, int result){
        final int actual = operand1 + operand2;
        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("입력받은 2개 정수를 뺀 후 결과값을 반환")
    @ParameterizedTest
    @MethodSource("subInputAndResult")
    void sub(int operand1, int operand2, int result){
        final int actual = operand1 - operand2;
        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("입력받은 2개 정수를 곱한 후 결과값을 반환")
    @ParameterizedTest
    @MethodSource("multiInputAndResult")
    void multi(int operand1, int operand2, int result){
        final int actual = operand1 * operand2;
        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("입력받은 2개 정수를 나눈 후 결과값을 반환")
    @ParameterizedTest
    @MethodSource("divInputAndResult")
    void div(int operand1, int operand2, int result){
        final int actual = operand1 / operand2;
        assertThat(actual).isEqualTo(result);
    }

    private static Stream<Arguments> dataAndResult(){
        return Stream.of(
                arguments("2 + 3 * 4 / 2", 10, true)
        );
    }

    private static Stream<Arguments> initDataAndResult(){
        return Stream.of(
                arguments("2 + 3 * 4 / 2", true)
                ,arguments("", false)
                ,arguments(null, false)
        );
    }

    private static Stream<Arguments> inDataAndResult(){
        return Stream.of(
                arguments("2 + 3 * 4 / 2", true)
        );
    }

    private static Stream<Arguments> arrayAndResult(){
        return Stream.of(
                arguments("2",true)
                ,arguments("+",false)
                ,arguments("3",true)
                ,arguments("*",false)
                ,arguments("4",true)
                ,arguments("/",false)
                ,arguments("2",true)
        );
    }

    private static Stream<Arguments> testDataAndResult(){
        return Stream.of(
                arguments("+",true)
                ,arguments("=",false)
        );
    }

    private static Stream<Arguments> addInputAndResult(){
        return Stream.of(
                arguments(1, 2, 3) // add(operand1, operand2, result)
        );
    }

    private static Stream<Arguments> subInputAndResult(){
        return Stream.of(
                arguments(3, 2, 1) // sub(operand1, operand2, result)
        );
    }

    private static Stream<Arguments> multiInputAndResult(){
        return Stream.of(
                arguments(3, 2, 6) // multi(operand1, operand2, result)
        );
    }

    private static Stream<Arguments> divInputAndResult(){
        return Stream.of(
                arguments(6, 2, 3) // div(operand1, operand2, result)
        );
    }
}
