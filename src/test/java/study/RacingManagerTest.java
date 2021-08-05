package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.racingcar.domain.Car;
import study.racingcar.domain.RacingManager;
import study.racingcar.domain.RandomMovingStrategy;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class RacingManagerTest {

    @DisplayName("랜덤 숫자가 0~9사이에서 리턴되는지 테스트")
    @Test
    public void getRandomNumberTest() {

        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        int randomNumber = randomMovingStrategy.getRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }

    @DisplayName("레이싱 카 리스트가 이름으로 만들어지는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"eddy : 1", "eddy,lily : 2", "eddy,lily,boss : 3"}, delimiter = ':')
    public void makeRacingCarByNameTest(String nameOfCars, int carListSize) {
        RacingManager racingManager = new RacingManager(nameOfCars);
        assertThat(carListSize).isEqualTo(racingManager.getCarList().size());
    }

    @DisplayName("자동차 이름이 5글자 초과 시 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"eddy,arnold", "arnold", "security,lily,boss"})
    public void makeRacingCarByNameTest(String nameOfCar) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new RacingManager(nameOfCar));
    }


    @DisplayName("우승자 목록 가져오는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"eddy", "buddy,boss", "buddy,lily,boss"})
    public void getRacingWinnersTest(String nameOfCar) {
        RacingManager racingManager = new RacingManager(nameOfCar);
        List<Car> racingWinners = racingManager.getRacingWinners();
        String winnerNames = String.join(",", racingWinners.stream().map(Car::getName).collect(Collectors.toList()));
        assertThat(winnerNames).isEqualTo(nameOfCar);
    }
}
