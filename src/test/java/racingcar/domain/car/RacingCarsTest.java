package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.random.FixedRandomNumberGenerator;
import racingcar.domain.random.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;

public class RacingCarsTest {
    private RacingCars cars;
    private final int anyNumber = 3;
    private final RandomNumberGenerator anyRandomGenerator = new FixedRandomNumberGenerator(anyNumber);

    @BeforeEach
    void setUp() {
        cars = new RacingCars(
                Arrays.asList(
                        new Car("abc", 1, anyRandomGenerator),
                        new Car("def", 2, anyRandomGenerator),
                        new Car("fgc", 1, anyRandomGenerator),
                        new Car("ff", 2, anyRandomGenerator)));
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
                .extracting(car -> car.name().value())
                .contains("def", "ff");
    }

    @Test
    void 관리하는_현재자동차_리스트를_알려준다() {
        List<Car> allCars = cars.all();

        Assertions.assertThat(allCars).hasSize(4);
    }
}
