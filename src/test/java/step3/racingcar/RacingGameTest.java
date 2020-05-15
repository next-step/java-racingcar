package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("차량 대수 Input만큼 Car 객체 배열을 생성받는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 8, 10})
    public void makeRacingCarObjectsInAccordanceWithInput(int carCounts) {
        CarFactory carFactory = new CarFactory();
        List<RacingCar> racingCars = carFactory.makeCars(carCounts);
        assertThat(racingCars.size()).isEqualTo(carCounts);
    }

    /*
    @DisplayName("차량 대수 Input을 입력받으면 RacingCar 객체를 Input 개수만큼 생성하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 3})
    public void makeRacingCarObjectInAccordanceWithInput(int carCounts) {
        RacingGame racingGame = new RacingGame();
        racingGame.setRacingCars(carCounts);;
        assertThat(racingGame.getRacingCars().size()).isEqualTo(carCounts);
    }

     */

    @DisplayName("조건에 맞으면 RacingCar 객체가 움직이는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {7, 9, 5, 6})
    public void moveRacingCarObjectWhenInputIsOver4(int randomNumber) {
        RacingGame racingGame = new RacingGame();
        racingGame.setRacingCars(1);
        racingGame.moveRacingCarByRandomNumber(racingGame.getRacingCars().get(0), randomNumber);
        assertThat(racingGame.getRacingCars().get(0).getPosition())
                .isEqualTo(1);
    }
}
