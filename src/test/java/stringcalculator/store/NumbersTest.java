package stringcalculator.store;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    void getNumbers_숫자만_추출하기() {
        //given
        String[] parsedInputs = new String[]{"1", "+", "2"};

        //when
        Numbers numbers = new Numbers(parsedInputs);

        //then
        assertThat(numbers.getNumbers()).hasSize(2);
    }

}