package racingcar.winner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringTest {

    @ParameterizedTest
    @CsvSource(value = "1,2,3,4:4", delimiter = ':')
    void string_split(String input, int expected) {
        Assertions.assertThat(input.split(",")).hasSize(expected);
    }

}
