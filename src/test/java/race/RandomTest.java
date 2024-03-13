package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import race.utils.RaceTestRule;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    @DisplayName("랜덤값을 고정시켜 줬을 때 고정된 값을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:1","4:4","9:9"},delimiter = ':')
    void randomIsDefaultValue(int input, int expected) {
        RaceTestRule raceRule = new RaceTestRule(() -> input);
        assertThat(raceRule.generate()).isEqualTo(expected);
    }

    @DisplayName("난수를 반환한다")
    @Test
    void randomIs() {
        RaceTestRule raceRule = new RaceTestRule(()
                -> new Random().nextInt(10));

        assertThat(raceRule.generate()).isBetween(0, 10);
    }
}
