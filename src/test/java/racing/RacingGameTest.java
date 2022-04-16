package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.AttemptsCountNegativeNumberException;
import racing.exception.CarsNullPointerException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임 시작 후 이동상태가 5번 추가된다")
    void carMoveStatusNullTest() {
        RacingCars cars = generateCars(new String[]{"CarA", "CarB"});

        RacingGameManagement racingGameManagement = initRacingGameManagement(cars);
        RacingGame racingGame = new RacingGame(cars, 5, racingGameManagement);
        racingGame.StartRacing();

        assertThat(racingGameManagement.findDrivingTypes(cars.findCarByCarName("CarA")).getAllMovingCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("레이싱 시작시 차량객체가 null 일 경우 CarsNullPointerException 가 발생한다")
    void carStatusNullTest() {
        assertThatExceptionOfType(CarsNullPointerException.class).isThrownBy(() -> {
            RacingGame racingGame = new RacingGame(null, 5, null);
            racingGame.StartRacing();
        });
    }

    @Test
    @DisplayName("시도횟수가 0이하일 경우 AttemptsCountNegativeNumberException 가 발생한다")
    void AttemptsCountZeroOrNegativeNumberTest() {
        RacingCars cars = generateCars(new String[]{"CarA"});
        assertThatExceptionOfType(AttemptsCountNegativeNumberException.class).isThrownBy(() -> {
            RacingGame racingGame = new RacingGame(cars, 0, null);
            racingGame.StartRacing();
        });
    }


    private static RacingCars generateCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(generateCar(carName));
        }
        return new RacingCars(cars);
    }

    private static Car generateCar(String carNames) {
        return new Car(carNames);
    }

    private static RacingGameManagement initRacingGameManagement(RacingCars racingCars) {
        Map<Car, CarDrivingTypes> racingGameManagement = new HashMap<>();

        for (Car car : racingCars) {
            racingGameManagement.put(car, new CarDrivingTypes(new ArrayList<CarDrivingType>()));
        }
        return new RacingGameManagement(racingGameManagement);
    }

}
