package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.moving.MovingStrategy;
import racingcar.moving.RandomMovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    private List<String[]> carNames = Arrays.asList(
            new String[] { "", "name" },
            new String[] { null, "name" },
            new String[] { "name1", "name2" },
            new String[] { "name1", "name2", "name3" }
    );

    @DisplayName("Cars 생성: Car 의 이름 배열을 생성자의 인자로 받아 생성")
    @Test
    void create() {
        assertThatCode(() -> Cars.of(carNames.get(3)))
                .doesNotThrowAnyException();
    }

    @DisplayName("Cars 생성 실패: name 이 빈 문자열이나 null 인 경우 예외 발생")
    @Test
    void createByThrown() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Cars.of(carNames.get(0)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Cars.of(carNames.get(1)));
    }

    @DisplayName("모든 Car 는 이동 또는 정지")
    @Test
    void moveCars() {
        Cars cars = Cars.of(carNames.get(3));
        cars.moveCars(new RandomMovingStrategy());

        assertThat(cars.getCars()
                .stream()
                .map(Car::getPosition)).containsAnyOf(Car.DEFAULT_DISTANCE, Car.DEFAULT_DISTANCE + 1);
    }

    @DisplayName("우승한(가장 멀리간) Cars 의 이름 배열 반환")
    @Test
    void getWinnerCars() {
        Cars cars = Cars.of(carNames.get(3));
        cars.moveCars(new SuccessMovingStrategy());

        List<String> winnerNames = cars.getWinnerCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(winnerNames).containsExactly(carNames.get(3));
    }

    public static class SuccessMovingStrategy implements MovingStrategy {
        @Override
        public boolean isMovable() {
            return true;
        }
    }
}
