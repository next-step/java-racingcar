package step1.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class IntegerEquationResolverTest {
    private EquationResolver sut = EquationResolverFactory.getEquationResolver("INTEGER");

    @Test
    void resolveEquation_returns_ProcessUnit_instance() {
        String equation = "1 + 2 + 3";
        assertThat(sut.resolveEquation(equation)).isInstanceOf(ProcessUnit.class);
    }

    @Test
    void resolveEquation_throws_IllegalArgumentException_to_abnormal_input() {
        String equation = "&&&&";
        assertThatThrownBy(() -> sut.resolveEquation(equation)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void resolveEquation_can_returns_ProcessUnit_instance_about_arithmetic_operators() {
        String equation = "+ - * /";
        assertThat(sut.resolveEquation(equation)).isInstanceOf(ProcessUnit.class);
    }
}
