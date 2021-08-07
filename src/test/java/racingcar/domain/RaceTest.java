package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RaceTest {

    @DisplayName("Race() : 입력된 Car 개수 만큼의 Car 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 20})
    void Race(int carNum) {
        Race race = new Race(carNum, 1);

        assertThat(race.getNumberOfCars()).isEqualTo(carNum);
    }

    @DisplayName("Race() : Car 개수 입력이 잘 못될 경우 Exception 발생")
    @ParameterizedTest
    @CsvSource({"0, 0", "0, 1", "1, 0"})
    void Race_ShouldThrowIllegalArgumentException(int carNum, int roundNum) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Race race = new Race(carNum, roundNum);
                });
    }

    @DisplayName("isRaceOver : 입력한 Round 만큼 Race를 진행 완료하면 true 반환")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4, 5, 6, 7, 10})
    void isRaceOver(int roundNum) {
        Race race = new Race(3, roundNum);

        for (int i = 0; i < roundNum; i++) {
            race.runOneRound();
        }

        assertThat(race.isRaceOver()).isEqualTo(true);
    }

    @DisplayName("isValidCarNum : CarNum 데이터 유효성 검사 - 최소값 이상이면 true")
    @ParameterizedTest
    @CsvSource({"-1, false", "0, false", "1, true", "3, true", "5, true", "100, true"})
    void inValidCarNum(int carNum, boolean expected) {
        assertThat(Race.isValidCarNum(carNum)).isEqualTo(expected);
    }

    @DisplayName("isValidRoundNum : RoundNum 데이터 유효성 검사 - 최소값 이상이면 true")
    @ParameterizedTest
    @CsvSource({"-1, false", "0, false", "1, true", "3, true", "5, true", "100, true"})
    void inValidRoundNum(int roundNum, boolean expected) {
        assertThat(Race.isValidRoundNum(roundNum)).isEqualTo(expected);
    }
}
