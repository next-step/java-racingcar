package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import race.car.Car;
import race.car.CarName;
import race.race.RandomNumber;

class CarTest {

    @Test
    void 자동차를_생성하면_전진하는_방향이_하나_생성된다() {
        Car car = new Car(new CarName("tCar"));

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_진행조건인_4이상의_수가_주어지면_한칸_전진한다() {
        Car car = new Car(new CarName("tCar"));

        car.forward(new RandomNumber(4));

        assertThat(car.getPosition()).isEqualTo(2);
    }
}
