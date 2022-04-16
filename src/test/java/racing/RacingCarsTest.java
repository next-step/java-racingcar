package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.CarNameMaximumLengthExceedException;
import racing.exception.RacingCarNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingCarsTest {

    @ParameterizedTest
    @DisplayName("자동차 이름을 5글자 미만으로 입력한다")
    @ValueSource(strings = {"자동차", "카", "수"})
    void carNamesTest(String carName) {
        Car car = new Car(carName);
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        RacingCars cars = new RacingCars(carList);

        for (Car c : cars) {
            assertThat(c.getCarName()).hasSizeBetween(1, 4);
        }
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5글자를 초과시 예외가 발생한다")
    @ValueSource(strings = {"레이싱카번호_1번"})
    void carNameMaximumLengthExceedExceptionTest(String carName) {
        assertThatExceptionOfType(CarNameMaximumLengthExceedException.class).isThrownBy(() -> {
            Car car = new Car(carName);
            List<Car> cars = new ArrayList<>();
            cars.add(car);
            new RacingCars(cars);
        });
    }

    @ParameterizedTest
    @DisplayName("carName 으로 Car 객체를 가져온다")
    @ValueSource(strings = {"레이싱카"})
    void findCarTest(String carName) {
        Car car = new Car(carName);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        RacingCars racingCars = new RacingCars(cars);
        Car byCar = racingCars.findCarByCarName(carName);

        assertThat(byCar).isEqualTo(car);
    }

    @ParameterizedTest
    @DisplayName("등록되지 않은 CarName 으로 Car 객체를 검색하면 예외가 발생한다")
    @ValueSource(strings = {"레이싱카"})
    void findCarNotFoundTest(String carName) {
        assertThatExceptionOfType(RacingCarNotFoundException.class).isThrownBy(() -> {
            Car car = new Car(carName);
            List<Car> cars = new ArrayList<>();
            cars.add(car);
            RacingCars racingCars = new RacingCars(cars);
            racingCars.findCarByCarName("없는차");
        });

    }
}
