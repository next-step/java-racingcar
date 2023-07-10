package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "100"})
    @DisplayName("양의 정수로 RaceCount를 생성하는 경우")
    void createByPositiveTest(final String inputRaceCount) {
        RaceCount raceCount = new RaceCount(inputRaceCount);

        assertThat(raceCount.toInt()).isEqualTo(Integer.parseInt(inputRaceCount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-100", "-1", "0"})
    @DisplayName("양수가 아닌 정수로 RaceCount를 생성하는 경우")
    void createByNotPositiveTest(final String inputRaceCount) {
        assertThatThrownBy(() -> new RaceCount(inputRaceCount)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"string", "1,234", "1+3"})
    @DisplayName("숫자가 아닌 문자가 포함된 문자열로 RaceCount를 생성하는 경우")
    void createByNotNumericTest(final String inputRaceCount) {
        assertThatThrownBy(() -> new RaceCount(inputRaceCount)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

}
