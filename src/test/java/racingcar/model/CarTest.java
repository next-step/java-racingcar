package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.enums.Status;
import racingcar.model.wrapper.ForwardNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 동등_비교(int number) {
        Car car = new Car();
        car.move(new ForwardNumber(number));

        Status status = Status.extractByNumber(new ForwardNumber(number));
        Car expected = new Car(List.of(status));

        assertThat(car).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void number_값이_4_이상일_경우_전진한다(int number) {
        Car car = new Car();
        car.move(new ForwardNumber(number));

        Car expected = new Car(List.of(Status.FORWARD));

        assertThat(car).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void number_값이_4_미만일_경우_멈춘다(int number) {
        Car car = new Car();
        car.move(new ForwardNumber(number));

        Car expected = new Car(List.of(Status.STOP));

        assertThat(car).isEqualTo(expected);
    }

    @Test
    void 자동차의_주어진_이동_횟수_동안_전진_멈춤_상태를_저장한다() {
        Car car = new Car();
        car.move(new ForwardNumber(4));
        car.move(new ForwardNumber(3));
        car.move(new ForwardNumber(2));
        car.move(new ForwardNumber(5));

        List<Status> statuses = List.of(Status.FORWARD, Status.STOP, Status.STOP, Status.FORWARD);
        Car expected = new Car(statuses);

        assertThat(car).isEqualTo(expected);
    }
}