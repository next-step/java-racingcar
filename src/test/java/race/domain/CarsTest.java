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

    @DisplayName("세 자동차 전부 똑같은 거리일 때 우승자는 세 명 전부임을 보여준다")
    @Test
    void name() {
        cars.goForward(() -> true);
        assertThat(cars.showWinnerNames()).isEqualTo("임형준, 박재성, 최승훈");
    }

    @DisplayName("세 번 전부 차의 전진 조건을 만족시키지 못하면 거리가 증가하지 않는 것을 보여준다")
    @Test
    void stop_test() {
        List<Car> firstRacingCars = cars.goForward(() -> false);
        assertThat(firstRacingCars.get(0).getPosition()).isEqualTo(0);
        assertThat(firstRacingCars.get(1).getPosition()).isEqualTo(0);
        assertThat(firstRacingCars.get(2).getPosition()).isEqualTo(0);

        List<Car> twoTimesRacingCars = cars.goForward(() -> false);
        assertThat(twoTimesRacingCars.get(0).getPosition()).isEqualTo(0);
        assertThat(twoTimesRacingCars.get(1).getPosition()).isEqualTo(0);
        assertThat(twoTimesRacingCars.get(2).getPosition()).isEqualTo(0);

        List<Car> threeTimesRacingCars = cars.goForward(() -> false);
        assertThat(threeTimesRacingCars.get(0).getPosition()).isEqualTo(0);
        assertThat(threeTimesRacingCars.get(1).getPosition()).isEqualTo(0);
        assertThat(threeTimesRacingCars.get(2).getPosition()).isEqualTo(0);
    }

    @DisplayName("세 번 전부 차의 전진 조건을 만족시키면 거리가 1씩 증가하는 것을 보여준다")
    @Test
    void goForward_test() {
        List<Car> firstRacingCars = cars.goForward(() -> true);
        assertThat(firstRacingCars.get(0).getPosition()).isEqualTo(1);
        assertThat(firstRacingCars.get(1).getPosition()).isEqualTo(1);
        assertThat(firstRacingCars.get(2).getPosition()).isEqualTo(1);

        List<Car> twoTimesRacingCars = cars.goForward(() -> true);
        assertThat(twoTimesRacingCars.get(0).getPosition()).isEqualTo(2);
        assertThat(twoTimesRacingCars.get(1).getPosition()).isEqualTo(2);
        assertThat(twoTimesRacingCars.get(2).getPosition()).isEqualTo(2);

        List<Car> threeTimesRacingCars = cars.goForward(() -> true);
        assertThat(threeTimesRacingCars.get(0).getPosition()).isEqualTo(3);
        assertThat(threeTimesRacingCars.get(1).getPosition()).isEqualTo(3);
        assertThat(threeTimesRacingCars.get(2).getPosition()).isEqualTo(3);
    }

}
