package racing.domain;

import Strategy.AboveNumberMove;
import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("레이싱 게임을 위한 자동차가 입력받은 개수만큼 생성되는지 확인한다")
    @Test
    void makeCars() {
        Cars cars = new Cars(5, new AboveNumberMove(4));

        assertThat(cars.getNumberOfCars()).isEqualTo(5);
    }

    @Test
    void race() {
        Cars cars = new Cars(3, new AboveNumberMove(0));

        cars.race();

        assertThat(cars.getCars()).extracting(Car::getLocation).containsExactly(1, 1, 1);
    }
}
