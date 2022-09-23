package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("여러 자동차를 등록한다.")
    @Test
    void createCars() {
        Cars cars = CarFactory.createCars("noose,pobi,honux");

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.getElements()).contains(
                new Car("noose"),
                new Car("pobi"),
                new Car("honux")
        );
    }

    @DisplayName("이름에 공백이 있는 경우 공백이 제거되고 생성된다.")
    @Test
    void createCarsWithWhitespace() {
        Cars cars = CarFactory.createCars("noose  , pobi, honux ");

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.getElements()).contains(
                new Car("noose"),
                new Car("pobi"),
                new Car("honux")
        );
    }

    @DisplayName("우승자를 찾을 수 있다.")
    @Test
    void findWinner() {
        List<Car> carList = List.of(
                new Car("a", 5),
                new Car("b", 10),
                new Car("c", 15));
        Cars cars = new Cars(carList);

        assertThat(cars.findWinners().size()).isEqualTo(1);
    }

    @DisplayName("두명 이상의 우승자를 찾을 수 있다.")
    @Test
    void findWinners() {
        List<Car> carList = List.of(
                new Car("a", 5),
                new Car("b", 15),
                new Car("c", 15));
        Cars cars = new Cars(carList);

        assertThat(cars.findWinners().size()).isEqualTo(2);
    }
}