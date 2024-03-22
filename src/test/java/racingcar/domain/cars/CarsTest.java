package racingcar.domain.cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.config.RacingCarException.CARS_EMPTY;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;

class CarsTest {

    @Test
    @DisplayName("가장 많이 이동한 자동차가 하나인 경우, 해당 자동차가 우승한다.")
    void winners_SingleWinner() {
        final Car winner = new Car("kyle", 2);
        final Cars cars = new Cars(
                winner,
                new Car("alex", 1),
                new Car("haley", 0)
        );

        final List<Car> winners = cars.winners().cars();

        assertThat(winners)
                .hasSize(1)
                .containsOnly(winner);
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차가 여럿인 경우, 해당 자동차들이 공동 우승한다.")
    void winners_MultipleWinners() {
        final Car winner1 = new Car("kyle", 2);
        final Car winner2 = new Car("alex", 2);
        final Cars cars = new Cars(
                winner1,
                winner2,
                new Car("haley", 0)
        );

        final List<Car> winners = cars.winners().cars();

        assertThat(winners)
                .hasSize(2)
                .containsOnly(winner1, winner2);
    }

    @Test
    @DisplayName("자동차 목록이 비어있는 경우, 우승자의 위치를 찾는 과정에서 예외를 던진다.")
    void winners_EmptyCars_Exception() {
        final Cars emptyCars = new Cars(List.of());

        assertThatThrownBy(emptyCars::winners)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(CARS_EMPTY.message());
    }

    @Test
    @DisplayName("참조는 다르지만 동등한 자동차 객체 목록을 반환한다.")
    void cars_CopyCarList() {
        final Car car1 = new Car("kyle", 0);
        final Car car2 = new Car("alex", 0);
        final Car car3 = new Car("haley", 0);

        final List<Car> originCars = List.of(car1, car2, car3);
        final List<Car> copiedCars = new Cars(car1, car2, car3).cars();

        assertThat(originCars)
                .isNotSameAs(copiedCars)
                .isEqualTo(copiedCars);
    }

    @Test
    @DisplayName("자동차 이름 목록을 통해 자동차들을 생성한다.")
    void from_CarNames_RacingCars() {
        final String[] names = {"kyle", "alex", "haley"};
        final CarNames carNames = CarNames.from(names);

        assertThat(Cars.from(carNames))
                .isNotNull();
    }
}
