package step3.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.car.Car;
import step3.car.RacingCar;
import step3.number.Number;
import step3.position.CarPosition;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("자동차들에게 턴을 사용할 있게 알람을 줄 수 있다.")
    void a() {
        Number number = new Number.Fake(4);
        Car car = new RacingCar(number);
        Cars sut = new RacingCars(List.of(car));

        Car movedCar = new RacingCar(new CarPosition(1), number);
        assertThat(sut.carsWithTurnUsed()).isEqualTo(new RacingCars(List.of(movedCar)));
    }

}
