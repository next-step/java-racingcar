package step3.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.car.RacingCar;
import step3.number.Number;
import step3.number.RandomNumber;
import step3.position.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("자동차들에게 턴을 사용할 있게 알람을 줄 수 있다.")
    void a() {
        Number number = new Number.Fake(4);
        RacingCar car = new RacingCar(number);
        RacingCars sut = new RacingCars(List.of(car));

        RacingCar movedCar = new RacingCar(new Position(1), number);
        assertThat(sut.carsWithTurnUsed()).isEqualTo(new RacingCars(List.of(movedCar)));
    }

    @Test
    @DisplayName("만드려는 자동차 개수를 입력하면 해당 개수 만큼 자동차들이 만들어진다")
    void b() {
        RacingCars.Factory sut = new RacingCars.Factory(1);

        RacingCar car = new RacingCar(new RandomNumber());
        assertThat(sut.cars()).isEqualTo(new RacingCars(List.of(car)));
    }


}
