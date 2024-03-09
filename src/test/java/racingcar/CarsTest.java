package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private static final String[] CAR_NAMES = {"a", "b", "c"};

    @Test
    @DisplayName("차 이름이 0개라면 예외가 발생한다")
    void new_cars_length_less_than_1() {
        assertThatThrownBy(() -> new Cars(new String[0]))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() {
        Cars cars = new Cars(CAR_NAMES);
        cars.drive(() -> true);
        List<Integer> drivingDistances = cars.drivingDistances();

        assertThat(drivingDistances).containsExactly(1, 1, 1);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() {
        Cars cars = new Cars(CAR_NAMES);
        cars.drive(() -> false);
        List<Integer> drivingDistances = cars.drivingDistances();

        assertThat(drivingDistances).containsExactly(0, 0, 0);
    }

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void result() {
        Cars cars = new Cars(CAR_NAMES);

        cars.drive(() -> true);
        assertThat(cars.result()).isEqualTo(
            String.format("%s : -\n%s : -\n%s : -", CAR_NAMES[0], CAR_NAMES[1], CAR_NAMES[2]));

        cars.drive(() -> true);
        assertThat(cars.result()).isEqualTo(
            String.format("%s : --\n%s : --\n%s : --", CAR_NAMES[0], CAR_NAMES[1], CAR_NAMES[2]));
    }

    @Test
    @DisplayName("우승자 목록을 가져온다 (단일 우승자)")
    void winners_single() {
        List<Car> listCars = List.of(new Car("a", 1), new Car("b", 0));
        Cars cars = new Cars(listCars);

        Winners winners = cars.winners();
        assertThat(winners.names())
            .containsExactly("a");
    }

    @Test
    @DisplayName("우승자 목록을 가져온다 (복수 우승자)")
    void winners_multi() {
        List<Car> listCars = List.of(new Car("a", 1), new Car("b", 1), new Car("c", 0));
        Cars cars = new Cars(listCars);

        Winners winners = cars.winners();
        assertThat(winners.names())
            .containsExactly("a", "b");
    }
}
