package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.movablestrategy.RandomRacingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("경주의 최소 차량 조건을 충족한다.")
    @Test
    void Cars_경주조건_충족() {
        Cars cars = new Cars(Racing.MINIMUM_CAR_COUNT);
        assertThat(cars.carsReady(Racing.MINIMUM_CAR_COUNT)).isTrue();
    }

    @DisplayName("구분된 문자열을 이름으로 문자열 개수만큼 자동차를 생성한다.")
    @Test
    void Cars_레이서_인원만큼_Car_생성() {
        Cars cars = new Cars("mon, fri, sat, sun", new RandomRacingStrategy());

        assertThat(cars.size()).isEqualTo(4);
        List<Car> expectedCars = List.of(
                new Car("mon", new RandomRacingStrategy()),
                new Car("fri", new RandomRacingStrategy()),
                new Car("sat", new RandomRacingStrategy()),
                new Car("sun", new RandomRacingStrategy())
        );

        List<Car> carsList = cars.getCars();

        assertThat(carsList).containsExactlyInAnyOrderElementsOf(expectedCars);
    }

    @DisplayName("가장 빠른사람이 한 명 일떄 이름을 리턴한다.")
    @Test
    void Cars_가장_빠른_레이서() {
        Car movableCar = new Car("a", () -> true);
        movableCar.move();
        Car pauseCar = new Car("b", () -> false);
        Cars cars = new Cars(List.of(movableCar, pauseCar));

        assertThat(cars.mostFastestCar()).containsExactly(movableCar);
    }

    @DisplayName("가장 빠른사람이 한 명 이상일떄 이름을 쉼표(,)로 구분해서 리턴한다.")
    @Test
    void Cars_가장_빠른_레이서들() {
        Car movableCar = new Car("a", () -> true);
        movableCar.move();
        Car anotherMovableCar = new Car("b", () -> true);
        anotherMovableCar.move();
        Cars cars = new Cars(List.of(movableCar, anotherMovableCar));

        assertThat(cars.mostFastestCar()).containsExactly(movableCar, anotherMovableCar);
    }
}