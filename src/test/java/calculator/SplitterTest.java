package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @Test
    @DisplayName("기본 문자열 split")
    void commonSplit()
    {
        Splitter splitter = new Splitter("1,2,3");
        assertThat(splitter.split()).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("커스텀 문자열 split")
    void customSplit() {
        Splitter splitter = new Splitter("//;\n1;2;3");
        assertThat(splitter.split()).containsExactly(1, 2, 3);
    }

}
