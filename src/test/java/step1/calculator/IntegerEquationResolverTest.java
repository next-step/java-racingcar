package step1.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class IntegerEquationResolverTest {
    private EquationResolver sut = EquationResolverFactory.getEquationResolver("INTEGER");

    @Test
    void resolve_equation_returns_process_unit_instance() {
        String equation = "1 + 2 + 3";
        assertThat(sut.resolveEquation(equation)).isInstanceOf(ProcessUnit.class);
    }

    @Test
    void resolve_equation_throws_illegal_argument_exception_to_abnormal_input() {
        String equation = "&&&&";
        assertThatThrownBy(() -> sut.resolveEquation(equation)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void resolve_equation_can_returns_process_unit_instance_about_arithmetic_operators() {
        String equation = "+ - * /";
        assertThat(sut.resolveEquation(equation)).isInstanceOf(ProcessUnit.class);
    }
}
