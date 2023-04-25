package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1. 참여할 자동차의 이름들을 입력하면 N대의 자동차가 생성된다.
 * 2. 참여한 자동차들이 한 경주를 돌면 0이나 1을 반환한다.
 */
public class GameTest {
    @DisplayName("pobi,conan,bob을 입력하면 3대의 자동차가 생성된다.")
    @Test
    void participate() {
        List<String> carNameList = Arrays.asList("pobi", "conan", "bob");
        List<Car> racingCar = Game.participate(carNameList);
        assertThat(racingCar).hasSize(3);
    }

    @DisplayName("참여한 자동차들이 한 경주를 돌면 0이나 1을 반환한다.")
    @Test
    void race() {
        List<Car> cars = List.of(new Car("pobi"),
                new Car("conan"),
                new Car("bob"));
        Game.race(cars);
        List<Integer> positoins = cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
        assertThat(positoins).containsAnyOf(0, 1);
    }

}
