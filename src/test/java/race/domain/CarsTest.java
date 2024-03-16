package race.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars(new String[]{"임형준", "박재성", "최승훈"});
    }

    @DisplayName("세 번 전부 차의 전진 조건을 만족시키지 못하면 거리가 증가하지 않는 것을 보여준다")
    @Test
    void stop_test() {
        List<Car> firstRacingCars = cars.goForward(() -> false);
        cars.goForward(() -> false);
        cars.goForward(() -> false);
        assertThat(firstRacingCars.get(0).maxComparedTo(0)).isEqualTo(0);
        assertThat(firstRacingCars.get(1).maxComparedTo(0)).isEqualTo(0);
        assertThat(firstRacingCars.get(2).maxComparedTo(0)).isEqualTo(0);
    }

    @DisplayName("세 번 전부 차의 전진 조건을 만족시키면 거리가 1씩 증가하는 것을 보여준다")
    @Test
    void goForward_test() {
        List<Car> firstRacingCars = cars.goForward(() -> true);
        cars.goForward(() -> true);
        cars.goForward(() -> true);
        assertThat(firstRacingCars.get(0).maxComparedTo(2)).isEqualTo(3);
        assertThat(firstRacingCars.get(1).maxComparedTo(2)).isEqualTo(3);
        assertThat(firstRacingCars.get(2).maxComparedTo(2)).isEqualTo(3);
    }

}
