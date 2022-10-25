package racingCar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @Test
    void 자동차_목록_초기화() {
        assertThat(new RacingCars(new String[]{"a", "b", "c"})).isEqualTo(new RacingCars(List.of(
                new RacingCar("a"),
                new RacingCar("b"),
                new RacingCar("c")
        )));
    }

}
