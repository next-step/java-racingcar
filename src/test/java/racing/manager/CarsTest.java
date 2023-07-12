package racing.manager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;

class CarsTest {

    @Test
    @DisplayName("우승자를 선별하는 경우")
    void checkWinnerTest() {
        Cars cars = createTestCars();

        List<String> winnerNames = cars.findWinnerNames();

        assertThat(winnerNames).hasSize(2);
        assertThat(winnerNames).containsExactlyInAnyOrder("pobi", "crong");
    }

    @Test
    @DisplayName("자동차들이 이동 조건에 맞게 움직이는지 테스트")
    void moveCarsTest() {
        /* given */
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("crong"), new Car("honux")));

        /* when */
        cars.moveCars(4, 10);  // 4 ~ 9 : 움직이는 경우
        cars.moveCars(4, 10);
        cars.moveCars(0, 4);  // 0 ~ 3 : 움직이지 않는 경우
        cars.moveCars(0, 4);

        /* then */
        assertThat(cars.getCars()).extracting("position").containsExactly(3, 3, 3);
    }

    private static Cars createTestCars() {
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("crong"),
                new Car("honux")
        );

        cars.get(0).move(3);
        cars.get(1).move(3);
        cars.get(2).move(1);

        return new Cars(cars);
    }

}
