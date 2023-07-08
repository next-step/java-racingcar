package racing.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.GameInfo;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "100"})
    @DisplayName("1 이상의 이동횟수를 입력하는 경우")
    void inputValidRaceCountTest(final String raceCount) {
        String systemInput = "VALID,CAR,NAME\n" + raceCount;
        System.setIn(new ByteArrayInputStream(systemInput.getBytes()));
        RacingReader racingReader = new RacingReader();

        GameInfo gameInfo = racingReader.inputForReady();

        assertThat(gameInfo.getRaceCount()).isEqualTo(Integer.parseInt(raceCount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-123", "-1", "0"})
    @DisplayName("0 이하의 이동횟수를 입력하는 경우 IllegalArgumentException 발생")
    void inputNegativeRaceCountTest(final String raceCount) {
        String systemInput = "VALID,CAR,NAME\n" + raceCount;
        System.setIn(new ByteArrayInputStream(systemInput.getBytes()));
        RacingReader racingReader = new RacingReader();

        assertThatThrownBy(racingReader::inputForReady).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"eng", "1,234", "0.123"})
    @DisplayName("0 이하의 이동횟수를 입력하는 경우 IllegalArgumentException 발생")
    void inputNotNumericRaceCountTest(final String raceCount) {
        String systemInput = "VALID,CAR,NAME\n" + raceCount;
        System.setIn(new ByteArrayInputStream(systemInput.getBytes()));
        RacingReader racingReader = new RacingReader();

        assertThatThrownBy(racingReader::inputForReady).isExactlyInstanceOf(IllegalArgumentException.class);
    }

}
