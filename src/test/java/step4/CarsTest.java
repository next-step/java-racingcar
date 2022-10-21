package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setup() {
        List<Car> carList = List.of(
                new Car("pobi", new Location(3)),
                new Car("crong", new Location(4)),
                new Car("honux", new Location(4))
        );
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("우승자 위치값을 가진 우승자이름들이 추가된다")
    void findWinnerTest() {
        assertThat(cars.findWinner().size()).isEqualTo(2);
        assertThat(cars.findWinner()).containsOnly("crong", "honux");
    }

    @Test
    @DisplayName("자동차의 이름과 위치값을 저장한다")
    void storeCarInfoTest() {
        assertThat(cars.storeCarNameAndLocation()).size().isEqualTo(3);
        assertThat(cars.storeCarNameAndLocation()).contains(entry("pobi", 3),
                entry("crong", 4),
                entry("honux", 4));
    }
}