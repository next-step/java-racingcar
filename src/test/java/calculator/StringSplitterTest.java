package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 StringSplitter 테스트")
class StringSplitterTest {
    @Test
    void split은_문자열_리스트를_반환한다() {
        List<String> expected = List.of("a", "b", "c");

        List<String> result = new StringSplitter("a,b,c", ",").split();

        assertThat(result).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource(value = {"a,b,c|", "|,", "|"}, delimiter = '|')
    void StringSplitter는_빈_문자로_생성_할_경우_런타임_예외를_발생시킨다(String operands, String delimiter) {
        assertThatThrownBy(() -> {
            new StringSplitter(operands, delimiter);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
