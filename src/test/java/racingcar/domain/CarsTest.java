package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.moving.MovingStrategy;
import racingcar.moving.RandomMovingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    private enum CASE {
        INCLUDED_EMPTY_VALUE, NULL_VALUE, THREE_VALUES, FOUR_VALUES
    }
    private static final Map<CASE, String> carNames = new HashMap<>();
    static {
        carNames.put(CASE.INCLUDED_EMPTY_VALUE, ",name");
        carNames.put(CASE.NULL_VALUE, null);
        carNames.put(CASE.THREE_VALUES, "name1,name2,name3");
        carNames.put(CASE.FOUR_VALUES, "name1,name2,name3,name4");
    }

    @DisplayName("Cars 생성: Car 의 이름 배열을 생성자의 인자로 받아 생성")
    @Test
    void create() {
        assertThatCode(() -> Cars.of(carNames.get(CASE.THREE_VALUES)))
                .doesNotThrowAnyException();
    }

    @DisplayName("Cars 생성 실패: name 이 빈 문자열이나 null 인 경우 예외 발생")
    @Test
    void createByThrown() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Cars.of(carNames.get(CASE.INCLUDED_EMPTY_VALUE)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Cars.of(carNames.get(CASE.NULL_VALUE)));
    }

    @DisplayName("모든 Car 는 이동 또는 정지")
    @Test
    void moveCars() {
        Cars cars = Cars.of(carNames.get(CASE.THREE_VALUES));
        cars.moveCars(new RandomMovingStrategy());

        assertThat(cars.getCars()
                .stream()
                .map(Car::getPosition))
                .containsAnyOf(Car.DEFAULT_DISTANCE, Car.DEFAULT_DISTANCE + 1);
    }

    @DisplayName("우승한(가장 멀리간) Cars 의 이름 배열 반환 - 짝수번째 자동자가 우승")
    @Test
    void getWinnerCars() {
        Cars cars = Cars.of(carNames.get(CASE.FOUR_VALUES));
        cars.moveCars(new EvenCarSuccessMovingStrategy());

        List<String> winnerNames = cars.getWinnerCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(winnerNames).containsExactly("name2", "name4");
    }

    public static class EvenCarSuccessMovingStrategy implements MovingStrategy {

        private int value;

        @Override
        public boolean isMovable() {
            value++;
            return value % 2 == 0;
        }
    }
}
