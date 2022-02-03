package calculator.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.domain.Formula;
import org.junit.jupiter.api.Test;

class FormulaTest {

    @Test
    void 유효하지않은_사칙연산기호() {
        assertThatThrownBy(() -> {
            new Formula("1 , 3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효하지않은_숫자기호() {
        assertThatThrownBy(() -> {
            new Formula(") + 3");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
