package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    void 자동차_생성() {
        List<Car> cars = GameMain.generateCar(3);
        int number_0 = cars.get(0).carNumber();
        int number_1 = cars.get(1).carNumber();
        int number_2 = cars.get(2).carNumber();
        int distance = cars.get(0).carDistance();

        assertThat(number_0).isEqualTo(0);
        assertThat(number_1).isEqualTo(1);
        assertThat(number_2).isEqualTo(2);
        assertThat(distance).isEqualTo(0);
    }

    @Test
    void Random_정수_생성() {
        int random = GameMain.random();
//        int random = new Random().nextInt(9);
        System.out.println("random = " + random);
        assertThat(random).isLessThanOrEqualTo(9);
    }

    @Test
    void 자동차_전진() {
        Car car1 = new Car(1);
        car1.move(5);
        int distance1 = car1.carDistance();
        assertThat(distance1).isEqualTo(1);

        Car car2 = new Car(2);
        car2.move(3);
        int distance2 = car2.carDistance();
        assertThat(distance2).isEqualTo(0);
    }

}
