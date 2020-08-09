package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarsTest {

    @DisplayName("이동 시행 횟수 입력값 없거나 0일 경우")
    @ParameterizedTest
    @CsvSource(value = {"1:0","3:0"}, delimiter = ':')
    public void whenZeroOrBlankRacingCounts(int carCounts, int racingCounts) {
        new Car(0);
        List<Car> carList = new ArrayList<>();
        RacingCars racingCars = new RacingCars(carList);
        List<Integer> expected = Arrays.asList(0);
        assertEquals(expected, racingCars.allDoRace(carCounts, racingCounts));
    }

    @DisplayName("자동차 대수 입력값 없거나 0일 경우")
    @Test
    public void whenZeroOrBlankCarCounts() {

    }


    @DisplayName("자동차 대수 : 2, 이동 시행 횟수 : 1 ")
    @Test
    public void whenTwoCarsRaceOneTime(){

    }
}
