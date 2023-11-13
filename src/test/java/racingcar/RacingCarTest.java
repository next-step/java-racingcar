package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingCar;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingCarTest {

    @Test
    void 큰값() {
        Car car = new Car(5);
        int actual = car.distance().max(10);
        assertThat(actual).isEqualTo(10);
    }

    @Test
    void 같은값() {
        Car car = new Car(5);
        boolean actual = car.distance().matchDistance(5);
        assertThat(actual).isTrue();
    }

    @Test
    void 우승자() {
        Car son = new Car("son", 5);
        Car john = new Car("john", 7);
        Car alice = new Car("alice", 3);
        List<Car> carList = Arrays.asList(son, john, alice);
        Cars cars = new Cars(carList);
        List<Car> actual = cars.findWinner();

        assertThat(actual).contains(john);
    }

    @Test
    void 자동차이름_길이확인() {
        assertThatThrownBy(() -> {
            Car actual = new Car("jonndan");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    void 랜덤값() {
        int actual = RacingCar.getRandom();
        assertAll(
                () -> assertThat(actual).isLessThanOrEqualTo(9),
                () -> assertThat(actual).isGreaterThanOrEqualTo(0)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진(int input) {
        Car actual = new Car("");
        actual.move(input);
        assertThat(actual).isEqualTo(new Car(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 멈춤(int input) {
        Car actual = new Car("");
        actual.move(input);
        assertThat(actual).isEqualTo(new Car(0));
    }
}
