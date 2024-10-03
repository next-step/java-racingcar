package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.wrapper.CarName;
import racingcar.model.wrapper.ForwardStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.model.enums.Status.FORWARD;
import static racingcar.model.enums.Status.STOP;
import static racingcar.model.fixture.CarFixture.*;
import static racingcar.model.fixture.CarsFixture.*;

public class CarsTest {
    @Test
    void 자동차들을_정적_팩토리_메소드로_생성한다() {
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);
        Car car3 = new Car(carName3);
        ArrayList<Car> carList = new ArrayList<>(List.of(car1, car2, car3));// NOTE: mutable object 구현을 위해 ArrayList 생성자로 래핑
        Cars expected = new Cars(carList);

        // when
        Cars actual = Cars.newInstance(car1, car2, car3);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차들의_한번_이동_횟수_동안_전진_멈춤_상태를_저장한다() {
        // given
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);
        Car car3 = new Car(carName3);
        Cars cars = new Cars(List.of(car1, car2, car3));

        Car car1Expected = new Car(carName1, List.of(FORWARD));
        Car car2Expected = new Car(carName2, List.of(FORWARD));
        Car car3Expected = new Car(carName3, List.of(FORWARD));
        Cars expected = new Cars(List.of(car1Expected, car2Expected, car3Expected));

        // when
        cars.moveAllByNumberCreator(() -> new ForwardStatus(4));

        // then
        assertThat(cars).isEqualTo(expected);
    }

    @Test
    void 자동차들의_주어진_이동_횟수_동안_전진_멈춤_상태를_저장한다() {
        // given
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);
        Car car3 = new Car(carName3);
        Cars cars = new Cars(List.of(car1, car2, car3));

        Car car1Expected = new Car(carName1, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car2Expected = new Car(carName2, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car3Expected = new Car(carName3, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Cars expected = new Cars(List.of(car1Expected, car2Expected, car3Expected));

        // when
        IntStream.range(0, 4).forEach((index) -> cars.moveAllByNumberCreator(() -> new ForwardStatus(4)));

        // then
        assertThat(cars).isEqualTo(expected);
    }

    @Test
    void 자동차들을_출력한다() {
        // given
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);
        Car car3 = new Car(carName3);
        Cars cars = new Cars(List.of(car1, car2, car3));

        Car car1Expected = new Car(carName1, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car2Expected = new Car(carName2, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car3Expected = new Car(carName3, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        List<Car> expected = List.of(car1Expected, car2Expected, car3Expected);

        IntStream.range(0, 4).forEach((index) -> cars.moveAllByNumberCreator(() -> new ForwardStatus(4)));

        // when
        List<Car> actual = cars.currentCars();

        // then
        assertThat(actual).containsAll(expected);
    }

    @Test
    void 자동차들을_외부에서_접근하여_변경할수_없다() {
        // given
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);
        Car car3 = new Car(carName3);
        ArrayList<Car> carList = new ArrayList<>(List.of(car1, car2, car3));// NOTE: mutable object 구현을 위해 ArrayList 생성자로 래핑
        Cars cars = new Cars(carList);

        // when
        List<Car> actual = cars.currentCars();

        // then
        assertThatThrownBy(() -> {
            actual.remove(0);
            actual.add(0, new Car(new CarName("name4")));
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 가장_많이_이동한_자동차의_전진_갯수를_리턴한다() {
        // given
        Car car1 = new Car(carName1, List.of(FORWARD, STOP, FORWARD, FORWARD));
        Car car2 = new Car(carName2, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Car car3 = new Car(carName3, List.of(FORWARD, FORWARD, FORWARD, FORWARD));
        Cars cars = new Cars(List.of(car1, car2, car3));

        // when
        int actual = cars.maxForwardCount();

        // then
        Assertions.assertThat(actual).isEqualTo(4);
    }
}
