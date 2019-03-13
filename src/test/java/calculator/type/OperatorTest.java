package calculator.type;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    public void null또는0인경우() {
        Operator operator = Operator.typeOf(null);
        assertThat(operator).isNull();

        operator = Operator.typeOf("sdfsrgerg");
        assertThat(operator).isNull();
    }

    @Test
    public void 연산자에_맞는_enum_return확인() {
        String operator = "+";
        Operator addType = Operator.typeOf(operator);
        assertThat(addType.getValue()).isEqualTo(Operator.ADD.getValue());

        operator = "-";
        Operator subType = Operator.typeOf(operator);
        assertThat(subType.getValue()).isEqualTo(Operator.SUBTRACT.getValue());

        operator = "*";
        Operator mulType = Operator.typeOf(operator);
        assertThat(mulType.getValue()).isEqualTo(Operator.MULTIPLY.getValue());

        operator = "/";
        Operator divType = Operator.typeOf(operator);
        assertThat(divType.getValue()).isEqualTo(Operator.DIVIDE.getValue());
    }

    @Test
    public void ADD_type확인() {
        int leftNumber = 10;
        int rightNumber = 20;
        String operator = "+";

        Operator addType = Operator.typeOf(operator);
        int result = addType.calculrate(leftNumber, rightNumber);
        assertThat(result).isEqualTo(30);
    }

    @Test
    public void MULTI_type확인() {
        int leftNumber = 10;
        int rightNumber = 20;
        String operator = "*";

        Operator mulType = Operator.typeOf(operator);
        int result = mulType.calculrate(leftNumber, rightNumber);
        assertThat(result).isEqualTo(200);
    }

    @Test
    public void DIV_type확인() {
        int leftNumber = 20;
        int rightNumber = 10;
        String operator = "/";

        Operator divType = Operator.typeOf(operator);
        int result = divType.calculrate(leftNumber, rightNumber);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void SUB_type확인() {
        int leftNumber = 10;
        int rightNumber = 20;
        String operator = "-";

        Operator subType = Operator.typeOf(operator);
        int result = subType.calculrate(leftNumber, rightNumber);
        assertThat(result).isEqualTo(-10);
    }
}