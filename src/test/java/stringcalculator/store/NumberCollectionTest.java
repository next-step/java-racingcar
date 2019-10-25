package stringcalculator.store;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberCollectionTest {

    @Test
    void getNumbers_숫자만_추출하기() {
        //given
        String[] parsedInputs = new String[]{"1", "+", "2"};

        //when
        NumberCollection numberCollection = new NumberCollection(parsedInputs);

        //then
        assertThat(numberCollection.getNumbers()).hasSize(2);
    }

}