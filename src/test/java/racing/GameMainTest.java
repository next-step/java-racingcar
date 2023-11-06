package racing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameMainTest {

    @Test
    void 자동차_생성() {

        List<Car> cars = GameMain.generateCar(3);

        for (int i = 0; i < 3; i++) {
            int number = cars.get(i).carNumber();
            assertThat(number).isEqualTo(i);
        }

        for (int i = 0; i < 3; i++) {
            int distance = cars.get(i).carDistance();
            assertThat(distance).isEqualTo(0);
        }
    }

    @Test
    void 게임_진행() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1));
        GameMain.goRacing(cars, 5);
        int distance = cars.get(0).carDistance();
        assertThat(distance).isLessThanOrEqualTo(5);
    }

}