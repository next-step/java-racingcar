package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.enums.Status;
import racingcar.model.wrapper.CarName;
import racingcar.model.wrapper.ForwardStatus;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.enums.Status.FORWARD;
import static racingcar.model.enums.Status.STOP;
import static racingcar.model.fixture.CarFixture.carName;
import static racingcar.model.fixture.CarsFixture.carName1;

public class CarTest {

    @Test
    void 자동차_초기값_생성() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            CarName carName = new CarName("pobi");
            List<Status> statuses = new ArrayList<>();

            Car car = new Car(carName, statuses);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 동등_비교(int number) {
        Car car1 = new Car(carName1);
        car1.move(() -> new ForwardStatus(number));

        Car car = new Car(carName);
        car.move(() -> new ForwardStatus(number));

        Status status = new ForwardStatus(number).status();
        Car expected = new Car(carName, List.of(status));

        assertThat(car1).isNotEqualTo(expected);
        assertThat(car).isEqualTo(expected);
    }

    @Test
    void 자동차를_정적_팩토리_메소드로_생성한다() {
        // given
        CarName carName = new CarName("name");
        Car expected = new Car(carName);

        // when
        Car actual = Car.newInstance(carName);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차의_한번_이동_횟수_동안_전진_멈춤_상태를_저장한다() {
        Car car = new Car(carName);
        car.move(() -> new ForwardStatus(4));

        List<Status> statuses = List.of(FORWARD);
        Car expected = new Car(carName, statuses);

        assertThat(car).isEqualTo(expected);
    }

    @Test
    void 자동차의_주어진_이동_횟수_동안_전진_멈춤_상태를_저장한다() {
        Car car = new Car(carName);
        car.move(() -> new ForwardStatus(4));
        car.move(() -> new ForwardStatus(3));
        car.move(() -> new ForwardStatus(2));
        car.move(() -> new ForwardStatus(5));

        List<Status> statuses = List.of(FORWARD, STOP, STOP, FORWARD);
        Car expected = new Car(carName, statuses);

        assertThat(car).isEqualTo(expected);
    }

    @Test
    void 자동차의_상태를_출력한다() {
        Car car = new Car(carName);
        car.move(() -> new ForwardStatus(4));
        car.move(() -> new ForwardStatus(3));
        car.move(() -> new ForwardStatus(2));
        car.move(() -> new ForwardStatus(5));

        List<Status> actual = car.currentStatus();
        List<Status> expected = List.of(FORWARD, STOP, STOP, FORWARD);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차의_이름을_출력한다() {
        // given
        String name = "name";
        Car car = new Car(new CarName(name));

        // when
        CarName actual = car.carName();

        // then
        assertThat(actual).isEqualTo(carName);
    }

    @Test
    void 자동차_상태들을_외부에서_접근하여_변경할수_없다() {
        // given
        Car car = new Car(carName);
        car.move(() -> new ForwardStatus(4));
        car.move(() -> new ForwardStatus(3));
        car.move(() -> new ForwardStatus(2));
        car.move(() -> new ForwardStatus(5));
        // when
        List<Status> actual = car.currentStatus();
        // then
        Assertions.assertThatThrownBy(() -> {
            actual.remove(0);
            actual.add(0, FORWARD);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 자동차의_현재_이동거리를_출력한다() {
        // given
        Car car = new Car(carName);
        car.move(() -> new ForwardStatus(4));
        car.move(() -> new ForwardStatus(3));
        car.move(() -> new ForwardStatus(2));
        car.move(() -> new ForwardStatus(5));
        // when
        int actual = car.currentForwardCount();
        // then
        Assertions.assertThat(actual).isEqualTo(2);
    }
}