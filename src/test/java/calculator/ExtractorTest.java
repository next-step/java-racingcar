package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExtractorTest {

    Extractor extractor = new Extractor("3 + 5 - 6");


    @Test
    void 숫자_추출_테스트() {
        List<Integer> actual = extractor.getNumbers();
        List<Integer> expected = new ArrayList<>(Arrays.asList(3, 5, 6));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 수식_추출_테스트() {
        List<Operator> actual = extractor.getOperators();
        List<Operator> expected = new ArrayList<>(Arrays.asList(Operator.PLUS, Operator.MINUS));

        assertThat(actual).isEqualTo(expected);
    }


}
