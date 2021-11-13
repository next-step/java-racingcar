package level2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class FactorTest {
    Factor factor = new Factor("2 + 3 * 4 / 2");

    @ParameterizedTest()
    @ValueSource(strings = {"2 + 3"})
    void split(String input) {
        String[] inputs = input.split(" ");
        assertThat(inputs).containsExactly("2","+","3");
    }

    @ParameterizedTest()
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void splitVariousValues(String input) {
        String[] inputs = input.split(" ");
        assertThat(inputs).containsExactly("2","+","3","*","4","/","2");
    }

    @ParameterizedTest
    @CsvSource({"1, true", "12, true", "*, false"})
    void isNumeric(String input, boolean expect) {
        assertThat(input.matches("-?\\d+?")).isEqualTo(expect);
    }

}