package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExtractorTest {
    @Test
    void 연산자_추출하기() {
        Extractor extractor = new Extractor();
        List<String> results = extractor.extractOperators(new String[]{"3", "+", "2"});
        assertThat(results).contains("+");
    }

    @Test
    void 숫자_추출하기() {
        Extractor extractor = new Extractor();
        List<Integer> results = extractor.extractNumbers(new String[]{"3", "+", "2"});
        assertThat(results).contains(3, 2);
    }
}