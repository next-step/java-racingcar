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
}
