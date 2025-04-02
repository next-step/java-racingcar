package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.dto.CarDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 컬렉션이 null 또는 비어있으면, 예외가 발생한다.")
    void construct(List<Car> cars) {
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 컬렉션에 빈 자동차가 포함되어있으면, 예외가 발생한다.")
    void constructWithCarsIncludingNull() {
        List<Car> cars = new ArrayList<>();
        cars.add(null);

        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("자동차 컬렉션에 포함된 자동차를 한번 전진한다.")
    void moveAll() {
        MoveStrategy moveStrategy = new MoveStrategy(new RandomNumberGenerator());
        List<Car> testCars = Arrays.asList(new Car("car1"), new Car("Car2"));
        Cars cars = new Cars(testCars);

        List<CarDto> result = cars.moveAll(moveStrategy);
        assertThat(result).hasSize(testCars.size());
    }


    @Test
    @DisplayName("자동차 경주 게임을 완료하면 우승자가 반환된다.")
    void findWinner() {
        Car carLuna = new Car("luna", 0);
        Car carStar = new Car("star", 3);
        Car carSun = new Car("sun", 2);

        Cars cars = new Cars(Arrays.asList(carLuna, carStar, carSun));
        List<CarDto> winners = cars.findWinners();

        assertThat(winners)
                .hasSize(1)
                .extracting("name", "position")
                .contains(tuple("star", 3));
    }

    @Test
    @DisplayName("자동차 경주 게임을 완료하면 다수의 우승자가 반환된다.")
    void findWinners() {
        Car carLuna = new Car("luna", 0);
        Car carStar = new Car("star", 3);
        Car carSun = new Car("sun", 3);

        Cars cars = new Cars(Arrays.asList(carLuna, carStar, carSun));
        List<CarDto> winners = cars.findWinners();

        assertThat(winners)
                .hasSize(2)
                .extracting("name", "position")
                .contains(tuple("star", 3))
                .contains(tuple("sun", 3));
    }
}