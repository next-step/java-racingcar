package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.AttemptsCountNegativeNumberException;
import racing.exception.CarsNullPointerException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingTest {

    @Test
    @DisplayName("Car 인스턴스 생성시 내부 관리 id가 함께 만들어진다")
    void generateCarTest() {
        Car car = new Car();
        assertThat(car.getId()).isNotNull();
    }

    @Test
    @DisplayName("레이싱카의 이동상태가 시도횟수만큼 저장된다")
    void moveCountTest() {
        List<Car> cars = generateCars(1);
        RacingGameManagement racingGameManagement = initRacingGameManagement(cars);
        Racing racing = new Racing(cars, 5, racingGameManagement);
        racing.StartRacing();

        assertThat(racingGameManagement.getStatus(cars.get(0).getId())).hasSize(5);
    }

    @Test
    @DisplayName("레이싱카의 이동상태에는 CarDriving enum 만 존재한다 ")
    void carMoveStatusNullTest() {
        List<Car> cars = generateCars(1);
        RacingGameManagement racingGameManagement = initRacingGameManagement(cars);
        Racing racing = new Racing(cars, 5, racingGameManagement);
        racing.StartRacing();

        assertThat(racingGameManagement.getStatus(cars.get(0).getId())).containsAll(Arrays.asList(CarDriving.GO, CarDriving.STOP));
    }

    @Test
    @DisplayName("차량객체가 null 일 경우 CarsNullPointerException 가 발생한다")
    void carStatusNullTest() {
        assertThatExceptionOfType(CarsNullPointerException.class).isThrownBy(() -> {
            Racing racing = new Racing(null, 5, null);
            racing.StartRacing();
        });
    }

    @Test
    @DisplayName("시도횟수가 0이하일 경우 AttemptsCountNegativeNumberException 가 발생한다")
    void AttemptsCountZeroOrNegativeNumberTest() {
        List<Car> cars = generateCars(1);
        assertThatExceptionOfType(AttemptsCountNegativeNumberException.class).isThrownBy(() -> {
            Racing racing = new Racing(cars, 0, null);
            racing.StartRacing();
        });
    }

    private static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(generateCar());
        }
        return cars;
    }

    private static Car generateCar() {
        return new Car();
    }

    private static RacingGameManagement initRacingGameManagement(List<Car> cars) {
        RacingGameManagement carDrivingStatus = new RacingGameManagement();

        for (Car car : cars) {
            carDrivingStatus.addCar(car.getId());
        }
        return carDrivingStatus;
    }

}
