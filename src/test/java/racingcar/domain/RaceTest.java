package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RaceTest {

    @DisplayName("Race() : 입력된 Car 개수 만큼의 Car 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 20})
    void Race(int carNum) {
        Race race = new Race(carNum, 1);

        assertThat(race.cars.size()).isEqualTo(carNum);
    }

    @DisplayName("Race() : Car 개수 입력이 잘 못될 경우 Exception 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void Race_ShouldThrowIllegalArgumentException(carNum, raceNum) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Race race = new Race(carNum, raceNum);
                });
    }
}
