package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static step2.Operator.*;

class OperatorParserTest {

    @Test
    void parseTest() throws Exception {
        OperatorParser operatorParser = new OperatorParser();
        List<String> inputs = asList("123", "-", "+", "2", "!", "1asd2", "/", "+", "*");

        //when
        List<Operator> results = operatorParser.parse(inputs);

        //then
        assertThat(results).isEqualTo(asList(MINUS, PLUS, DIVIDE, PLUS, MULTIPLY));
    }

}
