import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.ArithmeticArgumentFactory;
import stringcalculator.ArithmeticArguments;
import stringcalculator.Operator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArithmeticArgumentFactoryTest {
    private String data;

    @BeforeEach
    void setUp() {
        data = "2 + 3 * 4 / 2";
    }

    @Test
    void createArgsTest() {
        ArithmeticArguments args = ArithmeticArgumentFactory.createArgs(data);

        assertThat(args.nextOperator()).isEqualTo(makeArgs().nextOperator());
    }

    @DisplayName("정확한 stringcalculator.ArithmeticArguments 생성 여부에 대한 테스팅")
    ArithmeticArguments makeArgs() {
        Integer[] operands = new Integer[] {2, 3, 4, 2};
        Operator[] operators = new Operator[] {Operator.ADD, Operator.MULTIPLY, Operator.DIVIDE};

        return new ArithmeticArguments(Arrays.asList(operands), Arrays.asList(operators));
    }

    @DisplayName("유효 하지 않은 입력식에 대한 예외 발생 테스팅")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "asdfas 241243 asdlfjl 909"})
    void validationTest(String exp) {
        assertThatThrownBy(() ->ArithmeticArgumentFactory.createArgs(exp)).isInstanceOf(IllegalArgumentException.class);
    }
}