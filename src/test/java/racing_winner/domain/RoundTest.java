package racing_winner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    @DisplayName("경주 끝났는지 체크")
    void isFinish(int roundValue, boolean expectedResult) {
        Round round = new Round(roundValue);
        round.race();

        assertThat(round.isFinish()).isEqualTo(expectedResult);
    }

}