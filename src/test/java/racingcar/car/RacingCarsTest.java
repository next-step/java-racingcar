package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.random.RandomGenerator;

import java.util.Arrays;
import java.util.List;

public class RacingCarsTest {
    private RacingCars cars;

    @BeforeEach
    void setUp() {
        cars = new RacingCars(
                Arrays.asList(
                        new Car("abc", 1),
                        new Car("def", 2),
                        new Car("fgc", 1),
                        new Car("ff", 2)),
                new RandomGenerator(0,9));
    }

    @Test
    void 관리하는_자동차들중_가장_많이_이동한_차의_위치를_알려준다() {
        Position maxLocation = cars.maxLocation();

        Assertions.assertThat(maxLocation).isEqualTo(new Position(2));
    }

    @Test
    void 특정_위치에_존재하는_차들의_목록을_알려준다() {
        List<Car> winners = cars.findCarsAt(new Position(2));

        Assertions.assertThat(winners)
                .extracting(car -> car.name().getName())
                .contains("def", "ff");
    }

    @Test
    void 관리하는_현재자동차_리스트를_알려준다() {
        List<Car> allCars = cars.all();

        Assertions.assertThat(allCars).hasSize(4);
    }
}
