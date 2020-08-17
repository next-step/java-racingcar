package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.RaceCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarsTest {


    @Test
    void createCarsTest() {
        assertThat(RacingCars.createCars(5).size()).isEqualTo(5);
    }

    @DisplayName("이동 시행 횟수 입력값 없거나 0일 경우")
    @ParameterizedTest
    @CsvSource(value = {"1:0","3:0"}, delimiter = ':')
    public void whenZeroOrBlankRacingCounts(int carCounts, int racingCounts) {
        RacingCars racingCars = new RacingCars(carCounts, racingCounts);
        assertThat(racingCars.yesRacingCond()).isEqualTo(false);
    }


    @DisplayName("자동차 대수 입력값 없거나 0일 경우")
    @Test
    public void whenZeroOrBlankCarCounts() {
        /*
        Car alwaysZeroForwardCar = new Car(0);
        Car alwaysOneForwardCar = new Car(0);
        List<Car> testCars = Arrays.asList(alwaysOneForwardCar, alwaysZeroForwardCar);
        RaceCondition alwaysOneForwardCond = () -> true;
        RaceCondition alwaysZeroForwardCond = () -> false;
        alwaysZeroForwardCar.move(alwaysZeroForwardCond, new DoOneForward());
        alwaysOneForwardCar.move(alwaysOneForwardCond, new DoOneForward());
        RacingCars racingCars2 = new RacingCars(2, 5);
        */

    }


    @DisplayName("자동차 대수 : 2, 이동 시행 횟수 : 1 ")
    @Test
    public void whenTwoCarsRaceOneTime(){

    }
}
