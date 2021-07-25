package racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Racing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    @DisplayName("주어진 자동차 대수 만큼 경주하는지 확인")
    void race(int cars) {
        boolean[] racing = RacingService.race(cars);
        assertThat(cars).isEqualTo(racing.length);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:4", "4:5","5:6"}, delimiter = ':')
    @DisplayName("주어진 경주 횟수 만큼 실행되는지 확인")
    void exec(int round, int car) {
        List<Racing> racingHistory = RacingService.exec(round, car);
        assertThat(round).isEqualTo(racingHistory.size());
    }
}