package racinggame.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.car.stub.AlwaysGo;
import racinggame.car.stub.AlwaysStop;
import racinggame.strategy.MovingStrategy;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    @DisplayName("자동차 레이싱 우승자 출력하기")
    @Test
    void winner() {
        Car car1 = new Car(CarName.of("car1"));
        Car car2 = new Car(CarName.of("car2"));
        Car car3 = new Car(CarName.of("car3"));
        MovingStrategy go = new AlwaysGo();
        MovingStrategy stop = new AlwaysStop();

        car1.race(go);
        car1.race(go);
        car1.race(go);
        car2.race(stop);
        car2.race(stop);
        car2.race(go);
        car3.race(go);
        car3.race(go);
        car3.race(go);

        Cars cars = Cars.manyOf(Arrays.asList(car1, car2, car3));

        assertThat(cars.getWinner()).isEqualTo("car1, car3");
    }
}
