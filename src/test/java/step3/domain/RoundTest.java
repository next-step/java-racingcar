package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoundTest {

    @ParameterizedTest
    @CsvSource(value = {"1:1", "50:50", "100:100"}, delimiter = ':')
    @DisplayName("한 게임의 라운드 결과의 길이는 항상 게임시작시 입력한 자동차수와 같다.")
    void round_run_(int carCount, int expected) {
        RacingCars cars = new RacingCars(carCount);

        Round playedRound = new Round();
        playedRound.start(cars);

        assertThat(playedRound.getResults().size()).isEqualTo(expected);
    }
}