package stringcalculator.store;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorCollectionTest {

    @Test
    void getOperators_숫자가_아닌것들_수집하기() {
        //given
        String[] parsedInputs = new String[]{"1", "+", "2", "?", "5"};

        //when
        OperatorCollection operatorCollection = new OperatorCollection(parsedInputs);

        //then
        assertThat(operatorCollection.getOperators()).hasSize(2);
    }

}