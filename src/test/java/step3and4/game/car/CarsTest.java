package step3and4.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3and4.client.number.Number;
import step3and4.client.number.RandomNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차들에게 턴을 사용할 있게 알람을 줄 수 있다.")
    void a() {
        Number number = new Number.Fake(4);
        Car car = new Car(number);
        Cars sut = new Cars(List.of(car));

        Car movedCar = new Car(new Position(1), number);
        assertThat(sut.carsWithTurnUsed()).isEqualTo(new Cars(List.of(movedCar)));
    }

    @Test
    @DisplayName("만드려는 자동차 개수를 입력하면 해당 개수 만큼 자동차들이 만들어진다")
    void b() {
        Cars.Factory sut = new Cars.Factory(new String[]{"abc"});

        Car car = new Car(new RandomNumber(), "abc");
        assertThat(sut.cars(new Number.Fake(1))).isEqualTo(new Cars(List.of(car)));
    }

    @Test
    @DisplayName("자동차들을 출력할 수 있다.")
    void c() {
        Number number = new Number.Fake(4);
        Car car = new Car(number, "abced");
        Cars sut = new Cars(List.of(car));

        assertThat(sut.positionsAndNames()).containsExactly(car.toString());
    }
}
