package race;

import org.junit.jupiter.api.Test;
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

    @Test
    void 자동차_전진() {
        // given
        int[] carStates = {1, 2, 3};
        int carIndex = 0;
        int originalCarState = carStates[carIndex];

        // when
        Race.moveCarForward(carStates, carIndex);

        // then
        assertThat(carStates[carIndex]).isEqualTo(originalCarState + 1);
    }
}
