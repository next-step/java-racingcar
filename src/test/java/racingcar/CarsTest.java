package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;

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
        Cars cars = new Cars("mon, fri, sat, sun");

        assertThat(cars.size()).isEqualTo(4);

        List<Car> carsList = cars.getCars();

        assertThat(carsList)
                .usingRecursiveFieldByFieldElementComparator()
                .containsExactly(new Car("mon"), new Car("fri"), new Car("sat"), new Car("sun"));
    }

    @DisplayName("가장 빠른 자동차가 한 대 일떄 그 자동차만 포함한 리스트를 반환한다.")
    @Test
    void Cars_가장_빠른_자동차() {
        Car movableCar = new Car("a", 3);
        Car pauseCar = new Car("b", 0);
        Cars cars = new Cars(List.of(movableCar, pauseCar));

        assertThat(cars.mostFastestCar().size()).isEqualTo(1);
        assertThat(cars.mostFastestCar()).containsExactly(movableCar);
    }

    @DisplayName("가장 빠른 자동차가 두 대 이상일떄 자동차 리스트를 반환한다.")
    @Test
    void Cars_가장_빠른_자동차들() {
        Car samePositionCar1 = new Car("a", 3);
        Car samePositionCar2 = new Car("b", 3);
        Cars cars = new Cars(List.of(samePositionCar1, samePositionCar2));

        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.mostFastestCar()).containsExactly(samePositionCar1, samePositionCar2);
    }
}