package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExtractorTest {
    @Test
    void 짝수번째_추출하기() {
        Extractor extractor = new Extractor();
        List<String> results = extractor.extract(new String[]{"3", "+", "2"});
        assertThat(results).contains("+");
    }
}