package race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @ParameterizedTest
    @CsvSource(value = {"0:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    void 값이_4이상이면_전진_4미만이면_정지(int number, boolean expected) {
        // when
        boolean result = Race.canGo(number);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
