package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.model.wrapper.ForwardStatus;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static racingcar.model.enums.Status.FORWARD;

public class CarsTest {
    @Test
    void 자동차들의_한번_이동_횟수_동안_전진_멈춤_상태를_저장한다() {
        // given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Cars cars = new Cars(List.of(car1, car2, car3));

        Car car1Expected = new Car(List.of(FORWARD));
        Car car2Expected = new Car(List.of(FORWARD));
        Car car3Expected = new Car(List.of(FORWARD));
        Cars expected = new Cars(List.of(car1Expected, car2Expected, car3Expected));

        // when
        cars.moveAllByNumberCreator(() -> new ForwardStatus(4));

        // then
        assertThat(cars).isEqualTo(expected);
    }

    @Test
    void 자동차들의_주어진_이동_횟수_동안_전진_멈춤_상태를_저장한다() {
        // given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Cars cars = new Cars(List.of(car1, car2, car3));

        Car car1Expected = new Car(List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car2Expected = new Car(List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car3Expected = new Car(List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Cars expected = new Cars(List.of(car1Expected, car2Expected, car3Expected));

        // when
        IntStream.range(0, 4).forEach((index) -> cars.moveAllByNumberCreator(() -> new ForwardStatus(4)));

        // then
        assertThat(cars).isEqualTo(expected);
    }

    @Test
    void 자동차들을_출력한다() {
        // given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Cars cars = new Cars(List.of(car1, car2, car3));

        Car car1Expected = new Car(List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car2Expected = new Car(List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car3Expected = new Car(List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        List<Car> expected = List.of(car1Expected, car2Expected, car3Expected);

        IntStream.range(0, 4).forEach((index) -> cars.moveAllByNumberCreator(() -> new ForwardStatus(4)));

        // when
        List<Car> actual = cars.currentCars();

        // then
        assertThat(actual).containsAll(expected);
    }

}
