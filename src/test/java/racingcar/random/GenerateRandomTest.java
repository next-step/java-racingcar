package racingcar.random;

import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.random.GenerateRandom.moveCarForward;

class GenerateRandomTest {
    @Test
    void 자동차_전진_성공여부_랜덤발생_성공() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(2));
        assertThat(moveCarForward(cars).get(0).getStatus()).isGreaterThanOrEqualTo(2);
    }
}