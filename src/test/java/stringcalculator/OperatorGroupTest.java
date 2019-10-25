package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringcalculator.operation.OperatorGroup;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorGroupTest {

    @ParameterizedTest
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:MODIFY"}, delimiter = ':')
    void findOperator_연산자_찾기(String operator, String answer) {
        //given
        //when
        //then
        assertThat(OperatorGroup.findOperator(operator).name()).isEqualTo(answer);
    }

    @Test
    void findOperator_정의되지않은_연산자_입렵시() {
        //given
        String unknownOperator = "@";
        //when
        //then
        assertThatThrownBy(() -> OperatorGroup.findOperator(unknownOperator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"+:6", "-:0", "*:9", "/:1"}, delimiter = ':')
    void operate_더하기_빼기_곱하기_나누기_실행(String operator, Double answer) {
        //given
        Double x = 3D;
        Double y = 3D;
        OperatorGroup operatorGroup = OperatorGroup.findOperator(operator);

        //when
        Double result = operatorGroup.operate(x, y);

        //then
        assertThat(result).isEqualTo(answer);
    }
}