package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberCreator;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static racingcar.model.enums.Status.FORWARD;
import static racingcar.model.enums.Status.STOP;

public class CarsTest {
    @Test
    void 자동차들의_주어진_이동_횟수_동안_전진_멈춤_상태를_저장한다() {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        Cars cars = new Cars(List.of(car1, car2, car3));
        IntStream.range(0, 4).forEach((index) -> {
            cars.moveAll(numberCreator(car1, car2, car3));
        });

        Car car1Expected = new Car(List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car2Expected = new Car(List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car3Expected = new Car(List.of(STOP, STOP, STOP, STOP));
        Cars expected = new Cars(List.of(car1Expected, car2Expected, car3Expected));

        assertThat(cars).isEqualTo(expected);
    }

    @Test
    void 자동차들의_한번_이동_횟수_동안_전진_멈춤_상태를_저장한다() {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        Cars cars = new Cars(List.of(car1, car2, car3));

        cars.moveAll(numberCreator(car1, car2, car3));

        Car car1Expected = new Car(List.of(FORWARD));
        Car car2Expected = new Car(List.of(FORWARD));
        Car car3Expected = new Car(List.of(STOP));
        Cars expected = new Cars(List.of(car1Expected, car2Expected, car3Expected));

        assertThat(cars).isEqualTo(expected);
    }

    private static NumberCreator numberCreator(Car... cars) {
        int forwardNumber = 4;
        int stopNumber = 0;
        return car -> {
            if (cars[0].equals(car)) {
                return forwardNumber;
            }
            if (cars[1].equals(car)) {
                return forwardNumber;
            }
            return stopNumber;
        };
    }
}
