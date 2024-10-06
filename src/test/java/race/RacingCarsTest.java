package race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import race.domain.RacingCar;
import race.domain.RacingCars;

import java.util.List;

public class RacingCarsTest {
    @Test
    void 자동차_전진_여부_결정용_숫자들의_개수는_자동차_대수와_같아야한다() {
        // given
        List<RacingCar> cars = List.of(
                new RacingCar("car 1"),
                new RacingCar("car 2")
        );
        RacingCars racingCars = new RacingCars(cars);
        List<Integer> numbers = List.of(1, 2, 3);

        // when, then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> racingCars.moveAndReturnCarStateMessages(numbers))
                .withMessageMatching("입력값들의 개수는 자동차의 개수와 같아야 합니다")
        ;
    }
}
