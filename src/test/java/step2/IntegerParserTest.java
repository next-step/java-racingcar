package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class IntegerParserTest {

    @Test
    void parseTest() throws Exception {
        //given
        IntegerParser integerParser = new IntegerParser();
        List<String> inputs = asList("123", "12", "4235", "avs", "!", "1asd2", "6311", "103-3");

        //when
        List<Integer> results = integerParser.parse(inputs);

        //then
        assertThat(results).isEqualTo(asList(123, 12, 4235, 6311));
    }

}
