package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("여러 자동차를 등록한다.")
    @Test
    void createCars() {
        Cars cars = Cars.of("noose,pobi,honux");

        assertThat(cars.size()).isEqualTo(3);

        assertThat(cars.getElements()).isEqualTo(getFixtures());
    }

    @DisplayName("이름에 공백이 있는 경우 공백이 제거되고 생성된다.")
    @Test
    void createCarsWithWhitespace() {
        Cars cars = Cars.of("noose  , pobi, honux ");

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.getElements()).isEqualTo(getFixtures());
    }

    @DisplayName("우승자를 찾을 수 있다.")
    @Test
    void findWinner() {
        List<Car> carList = getWinnerFixture();
        Cars cars = new Cars(carList);

        assertThat(cars.findWinners().size()).isEqualTo(1);
    }

    @DisplayName("두명 이상의 우승자를 찾을 수 있다.")
    @Test
    void findWinners() {
        List<Car> carList = getWinnerFixtures();
        Cars cars = new Cars(carList);

        assertThat(cars.findWinners().size()).isEqualTo(2);
    }

    private List<Car> getWinnerFixture() {
        return List.of(
                new Car("a", 5),
                new Car("b", 10),
                new Car("c", 15));
    }

    private List<Car> getWinnerFixtures() {
        return List.of(
                new Car("a", 5),
                new Car("b", 15),
                new Car("c", 15));
    }

    private List<Car> getFixtures() {
        return List.of(new Car("noose"),
                new Car("pobi"),
                new Car("honux"));
    }
}