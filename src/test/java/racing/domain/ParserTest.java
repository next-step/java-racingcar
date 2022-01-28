package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import calculator.domain.Operation;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ParserTest {

    @ParameterizedTest
    @MethodSource
    void split_정상_작동(String input, String[] splits) {
        assertArrayEquals(Parser.split(input).toArray(), splits);
    }

    private static Stream<Arguments> split_정상_작동() {
        return Stream.of(
            Arguments.of("abc, bc,  de, c", new String[]{"abc", "bc", "de", "c"}),
            Arguments.of("ab c, bc,de, c", new String[]{"ab c", "bc", "de", "c"})
        );
    }

    @Test
    void split_빈칸_입력() {
        assertArrayEquals(Parser.split(" , ,자동차 ").toArray(),
            new String[]{"", "", "자동차"});
    }

}