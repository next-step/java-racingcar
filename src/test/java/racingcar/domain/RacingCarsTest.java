package racingcar.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    private static final RacingCar TEST_JASON = new RacingCar("jason", 999);
    private static final RacingCar TEST_POBI = new RacingCar("pobi", 0);
    private static final RacingCar TEST_CRONG = new RacingCar("crong", 0);
    private static final RacingCar TEST_HONUX = new RacingCar("honux", 0);

    @Test
    public void 생성() {
        // given
        final List<RacingCar> cars = Arrays.asList(TEST_POBI, TEST_CRONG, TEST_HONUX);

        // when
        final RacingCars racingCars = new RacingCars(cars);

        // then
        assertThat(racingCars).isNotNull();
        assertThat(racingCars.get()).hasSize(cars.size());
    }

    @Test
    public void 모든_자동차가_이동하는_경우() {
        // given
        final List<RacingCar> cars = Arrays.asList(TEST_POBI, TEST_CRONG, TEST_HONUX);
        final RacingCars racingCars = new RacingCars(cars);

        // when
        final RacingCars racingCarsAfterRacing = racingCars.race(() -> true);

        // then
        final List<RacingCar> carsAfterRacing = getMovedRacingCars(racingCarsAfterRacing);
        assertThat(carsAfterRacing).hasSize(cars.size());
    }

    @Test
    public void 모든_자동차가_이동하지_않는_경우() {
        // given
        final List<RacingCar> cars = Arrays.asList(TEST_POBI, TEST_CRONG, TEST_HONUX);
        final RacingCars racingCars = new RacingCars(cars);

        // when
        final RacingCars racingCarsAfterRacing = racingCars.race(() -> false);

        // then
        final List<RacingCar> carsAfterRacing = getMovedRacingCars(racingCarsAfterRacing);
        assertThat(carsAfterRacing).isEmpty();
    }

    @Test
    public void 가장_멀리_간_자동차_찾기() {
        // given
        final RacingCars racingCars = new RacingCars(Arrays.asList(TEST_POBI, TEST_CRONG, TEST_HONUX, TEST_JASON));

        // when
        final RacingCars whoWentTheFarthest = racingCars.whoWentTheFarthest();

        // then
        assertThat(whoWentTheFarthest.get()).containsExactly(TEST_JASON);
    }

    private List<RacingCar> getMovedRacingCars(final RacingCars racingCars) {
        return racingCars.get()
                .stream()
                .filter(racingCar -> racingCar.getPosition() > 0)
                .collect(Collectors.toList())
                ;
    }
}