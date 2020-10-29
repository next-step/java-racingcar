package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @ParameterizedTest
    @DisplayName("Enum 이름들을 확인한다.")
    @ValueSource(strings = {"PLUS", "MINUS", "MULTIPLY", "DIVISION"})
    void 이넘_이름_확인(String enumName) {

        System.out.println("enumName = " + enumName);
        assertThat(Operator.valueOf(enumName).toString()).isEqualTo(enumName);

    }

    @ParameterizedTest
    @DisplayName("+,-,*,/ 연산자가 잘 작동하는지 확인한다.")
    @CsvSource(value = {"1:2:+:3", "2:1:-:1:", "3:1:*:3", "4:2:/:2"}, delimiter = ':')
    void 연산_작동_확인(int x , int y , String operator , int expected) {

        int operatedValue = Operator.operate(x, y, operator);
        assertThat(operatedValue).isEqualTo(expected);

    }

}