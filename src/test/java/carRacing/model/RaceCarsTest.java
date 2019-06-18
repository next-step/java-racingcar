package carRacing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RaceCarsTest {

    @ParameterizedTest
    @CsvSource(value = {
            "a, b, c, d:4",
            "a, b, c, d, d:5",
            "a, b:2",
            "a, b, c, d, e, f:6",

    }, delimiter = ':')
    @DisplayName("자동차 옳바른 개수의 자동차생성")
    public void raceCarsTest(String input, int expected) {
        RaceCars raceCars = new RaceCars(input);
        assertThat(raceCars.getRaceCars().size()).isEqualTo(expected);
    }
}