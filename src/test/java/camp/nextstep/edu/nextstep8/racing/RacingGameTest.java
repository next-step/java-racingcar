package camp.nextstep.edu.nextstep8.racing;

import camp.nextstep.edu.nextstep8.stub.MoveForwardingRacingGameStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {

    @DisplayName("Racing game의 결과가 잘 나오는 지 확인 (3대의 차가 총 5회 경주를 하면, record는 5개, 기록은 3x5 = 15개")
    @ParameterizedTest
    @CsvSource(value = {
            "A,B,C:5:15",
            "A,B:3:6"
    }, delimiter = ':')
    public void raceStartTest(String cars, int roundTimes, int expected) {
        // when
        RacingGame racingGame = new RacingGame(cars, roundTimes);
        List<RacingEntry> records = racingGame.raceStart();

        int count = records.stream()
                    .map(entry -> entry.getEntryList().size())
                    .mapToInt(i -> i.intValue())
                    .sum();
        // then
        assertAll(
                () -> assertThat(records.size()).isEqualTo(roundTimes),
                () -> assertThat(count).isEqualTo(expected)
        );
    }

    @DisplayName("Racing game에 참가한 모든 자동차가 움직였다 가정했을 때 결과기록이 모두 0보다 커야 함")
    @ParameterizedTest
    @CsvSource(value = {
            "A,B,C:5:15",
            "A,B:3:6"
    }, delimiter = ':')
    public void raceStartMoveForwardTest(String cars, int roundTimes, int expected) {
        // when
        RacingGame racingGame = new MoveForwardingRacingGameStub(cars, roundTimes);
        List<RacingEntry> records = racingGame.raceStart();

        int count = records.stream()
                .map(entry -> entry.getEntryList()
                        .stream()
                        .filter(car -> car.getPosition() > 0)
                        .count())
                .mapToInt(Long::intValue)
                .sum();
        // then
        assertAll(
                () -> assertThat(records.size()).isEqualTo(roundTimes),
                () -> assertThat(count).isEqualTo(expected)
        );
    }
}
