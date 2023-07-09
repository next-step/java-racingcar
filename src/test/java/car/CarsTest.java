package car;

import static org.assertj.core.api.Assertions.assertThat;

import car.domain.Car;
import car.domain.Cars;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("winner 찾기")
    void 우승자_찾는_메서드() {
        // given
        List<Car> carList = List.of(new Car("he1", 1),
            new Car("he2", 2),
            new Car("he3", 3));
        Cars cars = new Cars(carList);
        // when
        List<Car> winners = cars.selectWinners();
        // then
        assertThat(winners).extracting("name").contains("he3");
    }


    @Test
    @DisplayName("winner 복수 찾기")
    void 우승자_여러명_찾는_메서드() {
        // given
        List<Car> carList = List.of(new Car("he1", 1),
            new Car("he2", 3),
            new Car("he3", 3));
        Cars cars = new Cars(carList);
        // when
        List<Car> winners = cars.selectWinners();
        // then
        assertThat(winners).extracting("name").contains("he2", "he3");
    }

}
