package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private static final String[] CAR_NAMES = {"a", "b", "c"};

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() {
        Cars cars = new Cars(() -> true, CAR_NAMES);
        cars.drive();
        List<Integer> drivingDistances = cars.drivingDistances();

        assertThat(drivingDistances).containsExactly(1, 1, 1);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() {
        Cars cars = new Cars(() -> false, CAR_NAMES);
        cars.drive();
        List<Integer> drivingDistances = cars.drivingDistances();

        assertThat(drivingDistances).containsExactly(0, 0, 0);
    }

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void getResult() {
        Cars cars = new Cars(() -> true, CAR_NAMES);

        cars.drive();
        assertThat(cars.getResult()).isEqualTo(String.format("%s : -\n%s : -\n%s : -", CAR_NAMES[0], CAR_NAMES[1], CAR_NAMES[2]));

        cars.drive();
        assertThat(cars.getResult()).isEqualTo(String.format("%s : --\n%s : --\n%s : --", CAR_NAMES[0], CAR_NAMES[1], CAR_NAMES[2]));
    }

    @Test
    @DisplayName("우승자 목록을 가져온다 (단일 우승자)")
    void getWinners_single() {
        List<Car> listCars = List.of(new Car(() -> true, "a"), new Car(() -> false, "b"));
        Cars cars = new Cars(listCars);
        cars.drive();

        List<Car> winners = cars.getWinners();
        assertThat(winners).containsExactly(listCars.get(0));
    }

    @Test
    @DisplayName("우승자 목록을 가져온다 (복수 우승자)")
    void getWinners_multi() {
        List<Car> listCars = List.of(new Car(() -> true, "a"), new Car(() -> true, "b"), new Car(() -> false, "c"));
        Cars cars = new Cars(listCars);
        cars.drive();

        List<Car> winners = cars.getWinners();
        assertThat(winners).containsExactly(listCars.get(0), listCars.get(1));
    }
}
