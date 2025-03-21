package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.domain.RandomMoveStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    @DisplayName("게임에서 자동차들이 시도 횟수만큼 이동한다.")
    void shouldStartRaceAndMoveCars() {
        Car car1 = new Car();
        Car car2 = new Car();
        List<Car> cars = Arrays.asList(car1, car2);
        Race race = new Race(cars, new RandomMoveStrategy());

        race.start(3);

        assertThat(car1.getPosition()).isBetween(0, 3);
        assertThat(car2.getPosition()).isBetween(0, 3);
    }

}
