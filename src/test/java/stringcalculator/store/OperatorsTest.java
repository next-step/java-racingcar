package stringcalculator.store;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorsTest {

    @Test
    void getOperators_숫자가_아닌것들_수집하기() {
        //given
        String[] parsedInputs = new String[]{"1", "+", "2", "?", "5"};

        //when
        Operators operators = new Operators(parsedInputs);

        //then
        assertThat(operators.getOperators()).hasSize(2);
    }

}