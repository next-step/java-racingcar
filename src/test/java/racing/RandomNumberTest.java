package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @ParameterizedTest
    @DisplayName("Random값이 0-bound 사이 인지")
    @ValueSource(ints = {10, 4, 1})
    void getRandomNumberTest(int bound) {
        assertThat(RandomNumber.getRandomNumber(bound)).isBetween(0, bound);

    }
}
