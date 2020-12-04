package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckorTest {

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "4:true", "9:true"}, delimiter = ':')
    @DisplayName("4미만이면 false, 4이상이면 true")
    void check(int input, boolean expected) {
        assertThat(Checkor.check(input)).isEqualTo(expected);
    }
}
