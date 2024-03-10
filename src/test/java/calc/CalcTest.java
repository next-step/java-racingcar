package calc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalcTest {

    @Test
    void null_또는_빈문자(){
        int result = Calc.process(null);
        assertThat(result).isEqualTo(0);

        result = Calc.process("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나(){
        int result = Calc.process("2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 쉼표_구분자(){
        int result = Calc.process("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론_구분자(){
        int result = Calc.process("1:2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자(){
        int result = Calc.process("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,+", "-1,2"})
    void 문자_또는_음수(String argument){
        assertThatThrownBy(() -> {
            Calc.process(argument);
        }).isInstanceOf(RuntimeException.class);
    }
}
