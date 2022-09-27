package step3.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.car.Car;
import step3.car.RacingCar;
import step3.number.Number;
import step3.position.CarPosition;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("자동차 등록하면 등록된 자동차 리스트들이 나온다.")
    void a() {
        final Number number = new Number.Fake(4);
        final Car car = new RacingCar(number);

        final Cars sut = new RacingCars();

        assertThat(sut.carsWithAddCar(car)).isEqualTo(new RacingCars().carsWithAddCar(car));
    }

    @Test
    @DisplayName("자동차들을 등록 해제하면 해제된 자동차 리스트들이 나온다.")
    void b() {
        final Number number = new Number.Fake(4);
        final Car car = new RacingCar(number);
        final Cars cars = new RacingCars();

        final Cars sut = cars.carsWithAddCar(car);

        assertThat(sut.carsWithRemoveCar(car)).isEqualTo(new RacingCars());
    }

    @Test
    @DisplayName("자동차들에게 턴을 사용할 있게 알람을 줄 수 있다.")
    void c() {
        final Number number = new Number.Fake(4);
        final Car car = new RacingCar(number);
        final Cars cars = new RacingCars();

        final Cars sut = cars.carsWithAddCar(car);

        assertThat(sut.carsWithTurnUsed()).isEqualTo(cars.carsWithAddCar(new RacingCar(new CarPosition(1), number)));
    }

}
