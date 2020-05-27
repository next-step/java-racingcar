package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.utils.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @ParameterizedTest
    @DisplayName("Random값이 0-bound 사이 인지")
    @CsvSource(value = {"10,10,true","10,4,false"}, delimiter = ',')
    void getRandomNumberTest(int bound, int max, boolean expected) {
        assertThat(0<= RandomNumber.getRandomNumber(bound) &&
                RandomNumber.getRandomNumber(bound) < max).isEqualTo(expected);

    }
}
